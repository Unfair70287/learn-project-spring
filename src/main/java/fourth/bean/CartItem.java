package fourth.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Cart")
@Component
public class CartItem implements Serializable{
	
	@Transient
	private String account;
	@Transient
	private String name;
	@Transient
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Transient
	private int user_id;
//	@Transient
//	private int item_id;
	private String itemName;
	private int count ;
	private double price;
	
	@Transient
	private int totalCount ;
	@Transient
	private double totalPrice;
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private CourseBean courseBean;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private MemberBean memberBean;
	
	public CartItem() {
		
	}
	
	
	public CartItem(int id, int user_id, int item_id, String itemName, int count,double price) {
		this.id = id;
		this.user_id = user_id;
		//this.item_id = item_id;
		this.itemName = itemName;
		this.count = count;
		this.price = price;
	}

	

	public CartItem(String account, String name, String email, int id, int user_id, int item_id, String itemName,
			int count, double price) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.id = id;
		this.user_id = user_id;
		//this.item_id = item_id;
		this.itemName = itemName;
		this.count = count;
		this.price = price;
	}



	public CartItem( int id, int user_id, String itemName, int count,
			double price, CourseBean courseBean) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.itemName = itemName;
		this.count = count;
		this.price = price;
		this.courseBean = courseBean;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	
	

	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

//	public int getItem_id() {
//		return item_id;
//	}
//
//	public void setItem_id(int item_id) {
//		this.item_id = item_id;
//	}

	
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



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	
	@Override
	public String toString() {
		return "CartItem [account=" + account + ", name=" + name + ", email=" + email + ", id=" + id + ", itemName="
				+ itemName + ", count=" + count + ", price=" + price + ", courseBean=" + courseBean + ", memberBean="
				+ memberBean + "]";
	}



	public CourseBean getCourseBean() {
		return courseBean;
	}



	public void setCourseBean(CourseBean courseBean) {
		this.courseBean = courseBean;
	}



	public MemberBean getMemberBean() {
		return memberBean;
	}



	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	
}
