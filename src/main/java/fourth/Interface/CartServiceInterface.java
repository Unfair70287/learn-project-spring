package fourth.Interface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import fourth.bean.CartItem;
import fourth.bean.CourseBean;



public interface CartServiceInterface {
	
	public String getCount(int id) throws IOException ;
		

	public void cartClear(int userId) ;
		

	public void cartAdd(String cartId,int id) throws SQLException;
		

	public void cartDelete(String id);
		

	public List<CartItem> cartList(int id);
		
	public List<CourseBean> courseList();
		
	public CartItem getCountPriceTotal(List<CartItem> cart);
		
}
