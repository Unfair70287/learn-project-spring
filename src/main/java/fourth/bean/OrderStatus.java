package fourth.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderStatus")
public class OrderStatus {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String status;
	
	@OneToMany(mappedBy = "status")
	List<OrderUser> orders ;
	
	public OrderStatus() {
		// TODO Auto-generated constructor stub
	}

	public OrderStatus(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderUser> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderUser> orders) {
		this.orders = orders;
	}
//
//	@Override
//	public String toString() {
//		return "OrderStatus [id=" + id + ", status=" + status + ", orders=" + orders + "]";
//	}
	
	
}
