package fourth.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "member")
@Component
public class MemberBean {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;

	@Column(name = "nick")
	private String nick;

	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;

	@Column(name = "name")
	private String name;

	@Column(name = "img")
	private String img;

	@Column(name = "sex")
	private String sex;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "email")
	private String email;

	@Column(name = "joinDate")
	private String joinDate;
	
//	//一個用戶對多個訂單
//	@OneToMany(mappedBy = "memberBean",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			 CascadeType.DETACH, CascadeType.REFRESH})
//	List<OrderUser> orderUsers;
//
//	@OneToMany(mappedBy = "memberBean",cascade = CascadeType.ALL)
//	private List<CartItem> cartItems;
	
	
	public MemberBean(Integer user_id, String nick, String account, String password, int status, String name,
			String img, String sex, String birthday, String cellphone, String email, String joinDate) {
		super();
		this.user_id = user_id;
		this.nick = nick;
		this.account = account;
		this.password = password;
		this.status = status;
		this.name = name;
		this.img = img;
		this.sex = sex;
		this.birthday = birthday;
		this.cellphone = cellphone;
		this.email = email;
		this.joinDate = joinDate;
	}

	public MemberBean() {

	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
//	public List<OrderUser> getOrderUsers() {
//		return orderUsers;
//	}
//	public void setOrderUsers(List<OrderUser> orderUsers) {
//		this.orderUsers = orderUsers;
//	}
//	
//	
//	//用戶加入訂單
//	public void addorderUsers(OrderUser orderUser) {
//		
//		if(orderUsers == null) {
//			orderUsers = new ArrayList<>();
//		}
//		
//		orderUsers.add(orderUser);
//	}
//
//	public List<CartItem> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(List<CartItem> cartItems) {
//		this.cartItems = cartItems;
//	}

	@Override
	public String toString() {
		return "MemberBean [user_id=" + user_id + ", nick=" + nick + ", account=" + account + ", password=" + password
				+ ", status=" + status + ", name=" + name + ", img=" + img + ", sex=" + sex + ", birthday=" + birthday
				+ ", cellphone=" + cellphone + ", email=" + email + ", joinDate=" + joinDate + "]";
	}
	
	
}
