package fourth.Interface;

import java.util.List;

import org.springframework.stereotype.Component;

import fourth.bean.CartItem;
import fourth.bean.OrderUser;


@Component
public interface OrderDAO {
	public void addOrder(List<CartItem> cart );
	public void deleteOrder(String orderID);
	public void updateOrder(OrderUser user,int orderStatus);
	public List<OrderUser> orderList(int id);
	public OrderUser orderUser(String orderID);
	public List<OrderUser> orderSearch(String search);
}
