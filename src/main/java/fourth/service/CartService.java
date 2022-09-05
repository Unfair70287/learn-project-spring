package fourth.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import fourth.Interface.CartServiceInterface;
import fourth.bean.CartItem;
import fourth.bean.CourseBean;
import fourth.dao.CartDaoImpt;
import fourth.dao.CourseDao;
import fourth.util.WebUtils;

@Service
@Transactional
public class CartService {
	
	@Autowired
	CartDaoImpt cartDaoImpt ;
	
	@Autowired
	CourseDao courseDao ;
	
	//@Override
	public String getCount(int id) throws IOException {
		List<CartItem> carList = cartDaoImpt.carList(id);
		CartItem cart = cartDaoImpt.getCountTotal(carList);
		Gson gson = new Gson();
		try {
			
			String JsonString = gson.toJson(cart);
			return JsonString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//@Override
	public void cartClear(int userId) {
		cartDaoImpt.clearCard(userId);
	}

	//@Override
	public void cartAdd(String cartId,int id) throws SQLException{
		CourseBean course = courseDao.select(WebUtils.paseInt(cartId));
		CartItem cart = new CartItem(0, id, course.getCourse_id(), course.getCourse_name(), 1,
				course.getCourse_price());
		cart.setCourseBean(course);
		cartDaoImpt.addCart(cart);
	}

	//@Override
	public void cartDelete(String id){
		cartDaoImpt.deleteCart(WebUtils.paseInt(id));

	}

	//@Override
	public List<CartItem> cartList(int id){
		List<CartItem> cartList = cartDaoImpt.carList(id);
		//List countTotal = cartDaoImpt.getCountTotal(cartList);
		return cartList;
	}
	
	//@Override
	public List<CourseBean> courseList(){
		List<CourseBean> selectAll = courseDao.selectAll();
		return selectAll;
	}
	
	//@Override
	public CartItem getCountPriceTotal(List<CartItem> cart) {
		 CartItem countTotal = cartDaoImpt.getCountTotal(cart);
		 if(countTotal == null) {
			 countTotal = new CartItem();
			 countTotal.setTotalCount(0);
			 countTotal.setPrice(0);
		 }
		return countTotal;
	}
	
}
