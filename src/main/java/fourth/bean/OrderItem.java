package fourth.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private int item_id ;
	private String name; 
	private int count = 1; 
	private double price;
	@Transient
	private String order_id;  
	
	@OneToOne
	@JoinColumn(name = "order_id")
	OrderUser orderUser;
	
	public OrderItem() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderItem(int id, String order_id, int item_id, String name, int count, double price) {
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	
	
	public OrderUser getOrderUser() {
		return orderUser;
	}
	public void setOrderUser(OrderUser orderUser) {
		this.orderUser = orderUser;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order_id=" + order_id + ", item_id=" + item_id + ", name=" + name + ", count="
				+ count + ", price=" + price + "]";
	} 
	
}
