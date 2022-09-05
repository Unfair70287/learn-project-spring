package fourth.Interface;

import java.util.List;

import org.springframework.stereotype.Component;

import fourth.bean.CartItem;
import fourth.bean.OrderItem;


@Component
public interface OrderItemDAO {
	public void addOrderItem(String orderID,List<CartItem> cart);
	//public void deleteOrderItem(String orderID);
	public List<OrderItem> orderItemList(String orderID);
}
