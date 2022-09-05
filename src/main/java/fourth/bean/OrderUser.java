package fourth.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Order_user")
public class OrderUser implements Serializable{
	
	@Transient
	private String account;
	@Transient
	private String name;
	@Transient
	private String email;
	@Transient
	private String cellphone;
	
	@Id
	@Column(name = "order_id")
	private String order_id;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "status")
	private OrderStatus status;
	private int totoalcount = 1;
	private String discount;
	private double totoalprice;
	
	
//	@Transient
//	private int user_id;

	@OneToMany(mappedBy = "orderUser" ,cascade = CascadeType.ALL)
	List<OrderItem> orderItems ;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	MemberBean memberBean ;
	
	
	
	public OrderUser() {
		
	}
	
	public OrderUser(String order_id, int user_id, Date date, OrderStatus status, int totoalcount, String discount,
			double totoalprice) {
		this.order_id = order_id;
		//this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	
	public OrderUser(String account, String name, String email, String order_id, int user_id, Date date, OrderStatus status,
			int totoalcount, String discount, double totoalprice) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.order_id = order_id;
		//this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	

	public OrderUser(String account, String name, String email, String cellphone, String order_id, int user_id,
			Date date, OrderStatus status, int totoalcount, String discount, double totoalprice) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.order_id = order_id;
		//this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	
	
	
	public OrderUser(String account, String name, String email, String cellphone, String order_id, Date date,
			OrderStatus status, int totoalcount, String discount, double totoalprice, List<OrderItem> orderItems,
			MemberBean memberBean) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.order_id = order_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
		this.orderItems = orderItems;
		this.memberBean = memberBean;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public int getTotoalcount() {
		return totoalcount;
	}
	public void setTotoalcount(int totoalcount) {
		this.totoalcount = totoalcount;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public double getTotoalprice() {
		return totoalprice;
	}
	public void setTotoalprice(double totoalprice) {
		this.totoalprice = totoalprice;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}
	
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	
	
	public List<OrderItem> getorderItems() {
		return orderItems;
	}

	public void setorderItems(List<OrderItem> orderItems) {
		orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderUser [order_id=" + order_id  + ", date=" + date + ", status=" + status
				+ ", totoalcount=" + totoalcount + ", discount=" + discount + ", totoalprice=" + totoalprice + "]";
	}
	
	public void addorderItems(OrderItem item) {
		
		if(orderItems == null) {
			orderItems = new ArrayList<>();
		}
		
		orderItems.add(item);
	}
	
}
