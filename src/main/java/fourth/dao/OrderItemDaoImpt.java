package fourth.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.CartItem;
import fourth.bean.CourseBean;
import fourth.bean.OrderItem;
import fourth.bean.OrderUser;


@Repository
@Transactional
public class OrderItemDaoImpt {

	@Autowired
	SessionFactory factory ;
	
	public OrderItemDaoImpt() {
		//factory = HibernateUtil.getFactory();
	}
	
	//@Override
	public void addOrderItem(String orderID , List<CartItem> cart,Session session) {
		
		try {
			OrderUser orderUser = session.get(OrderUser.class, orderID);
			System.out.println(orderUser);
			for(CartItem item : cart) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder_id(orderID);
				orderItem.setItem_id(item.getCourseBean().getCourse_id());
				orderItem.setName(item.getItemName());
				orderItem.setCount(item.getCount());
				orderItem.setPrice(item.getCourseBean().getCourse_price());
				orderItem.setOrderUser(orderUser);
				session.save(orderItem);
				orderUser.addorderItems(orderItem);
			}
			//session.save(orderUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<OrderItem> orderItemList(String orderID) {
		Session session = factory.getCurrentSession();
		try {
			List<OrderItem> resultList = session.createQuery("from OrderItem where order_id = :id", OrderItem.class)
			.setParameter("id", orderID).getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> orderItemIDList(String orderID) {
		Session session = factory.getCurrentSession();
		try {
			List<Integer> resultList = session.createQuery("select item_id from OrderItem where order_id = :id", Integer.class)
			.setParameter("id", orderID)
			.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Integer> orderItemIDList(String orderID ,Session session) {
		try {
			List<Integer> resultList = session.createQuery("select item_id from OrderItem where order_id = :id", Integer.class)
					.setParameter("id", orderID)
					.getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateEnrollment(int enrollment,int id) {
		Session session = factory.getCurrentSession();
		try {
			CourseBean courseBean = session.get(CourseBean.class, id);
			courseBean.setEnrollment(enrollment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

}
