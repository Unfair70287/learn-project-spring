package fourth.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fourth.bean.CartItem;
import fourth.bean.CourseBean;
import fourth.bean.MemberBean;
import fourth.service.CartService;
import fourth.service.CourseService;
import fourth.util.WebUtils;

@Controller
@SessionAttributes(names = {"user"})
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CourseService cService;
	
	@Autowired
	CartItem countPriceTotal;
	
	@GetMapping(path = "/cartList")
	public String cartList(Model m) {
		MemberBean user = (MemberBean)m.getAttribute("user");
		List<CartItem> cartList = cartService.cartList(user.getUser_id());
		m.addAttribute("cartList", cartList);
		CartItem countPriceTotal = cartService.getCountPriceTotal(cartList);
		m.addAttribute("countPriceTotal",countPriceTotal);
		return "Cart";
	}
	
	@PostMapping(path = "/addCart")
	public String addCart(Model m, String courseID) throws SQLException {
		MemberBean user = (MemberBean)m.getAttribute("user");
		cartService.cartAdd(courseID,user.getUser_id());
		CourseBean cbean = cService.select(WebUtils.paseInt(courseID));
		m.addAttribute("cbean", cbean); 
		return "Details";
	}
	
	@GetMapping(path = "deleteCart")
	public String deleteCart(String cartID) {
		cartService.cartDelete(cartID);
		return "redirect:/cartList";
	}
	
	@PostMapping(path = "clearCart")
	public String clearCart(Model m) {
		MemberBean user = (MemberBean)m.getAttribute("user");
		cartService.cartClear(user.getUser_id());
		return "redirect:/cartList";
	}
	
	@GetMapping(path = "cartCount")
	@ResponseBody
	public String cartTotalCountPrice(Model m) throws IOException {
		MemberBean user = (MemberBean)m.getAttribute("user");
		if(user != null) {
			List<CartItem> cartList = cartService.cartList(user.getUser_id());
			countPriceTotal = cartService.getCountPriceTotal(cartList);
		}else {
			countPriceTotal.setTotalCount(0);
		}
		return String.valueOf(countPriceTotal.getTotalCount());
	}
}
