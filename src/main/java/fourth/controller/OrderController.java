package fourth.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fourth.bean.CourseBean;
import fourth.bean.MemberBean;
import fourth.bean.OrderItem;
import fourth.bean.OrderUser;
import fourth.ecpay.payment.integration.domain.AioCheckOutALL;
import fourth.service.OrderService;

@Controller
@SessionAttributes(names = {"user"})
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@GetMapping(path = "/orderList")
	public String orderList(Model m) {
		MemberBean user = (MemberBean)m.getAttribute("user");
		List<OrderUser> orderList = orderService.orderList(user.getUser_id(),user.getStatus());
		System.out.println(orderList);
		m.addAttribute("order",orderList);
		return "order";
	}
	
	@PostMapping(path = "/orderAdd")
	public String addOrder(Model m) {
		MemberBean user = (MemberBean)m.getAttribute("user");
		orderService.addOrder(user.getUser_id());
		return "redirect:/orderList";
	}
	
	@PostMapping(path = "/deleteOrder")
	public String deleteOrder(String cartID) {
		orderService.deleteOrder(cartID);
		return "redirect:/orderList";
	}
	@PostMapping(path = "/orderDetail")
	public String orderDetail(String cartID,Model m) {
		List<OrderItem> orderItemList = orderService.orderItemList(cartID);
		OrderUser orderItemUser = orderService.orderItemUser(cartID);
		m.addAttribute("itemList",orderItemList);
		m.addAttribute("order",orderItemUser);
		return "orderUpdate";
	}
	@PostMapping(path = "/goEcpay")
	public String goEcpay(HttpServletRequest request, String orderID,Model m) {
		String url =request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		AioCheckOutALL obj = new AioCheckOutALL();
		String ecPay = orderService.ecPay(orderID, url, obj);
		m.addAttribute("ecpay",ecPay);
		return "ecpay";
	}
	@GetMapping(path = "/updateOrder/{status}/{orderId}")
	public String updateOrder(HttpServletRequest request, 
		@PathVariable(required = false , value = "status")	int status,
		@PathVariable("orderId") String orderId,
		@RequestParam(required = false,value = "updateStatus" ) String updateStatus,
		Model m) throws SQLException  {
		MemberBean user = (MemberBean)m.getAttribute("user");
		if(status == 0) {
			status = Integer.parseInt(updateStatus);
		}
		orderService.updateOrder(user.getStatus(), status, orderId);
		return "redirect:/orderList";
	}
	@PostMapping(path = "/searchOder")
	public String updateOrder(@RequestParam(required = false) String search,Model m)  {
		//String search = (String)m.getAttribute("search");
		System.out.println(search);
		List<OrderUser> orderSearch = orderService.orderSearch(search);
		if(orderSearch == null) {
			m.addAttribute("search","無");
		}
		m.addAttribute("order",orderSearch);
		return "order";
	}
	@GetMapping(path = "/searchLearn")
	public String searchLearn(Model m) throws SQLException  {
		MemberBean user = (MemberBean)m.getAttribute("user");
		List<CourseBean> searchLearn = orderService.searchLearn(user.getUser_id());
		System.out.println(searchLearn);
		int ran = (int)(Math.random()* 5 + 1);
		m.addAttribute("ran",ran);
		m.addAttribute("myItem",searchLearn);
		return "myLearn";
	}

}
