package fourth.Interface;

import java.util.List;

import fourth.bean.CartItem;




public interface CartDAO {
	public List<CartItem> carList(int id);
	public void addCart(CartItem cart);
	public void deleteCart(int itemID);
	public void clearCard(int userID);
	public CartItem getCountTotal(List<CartItem> cart);
}
