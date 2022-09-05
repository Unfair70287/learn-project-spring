package fourth.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fourth.Interface.CartDAO;
import fourth.bean.CartItem;
import fourth.bean.CourseBean;
import fourth.bean.MemberBean;



@Repository
@Transactional
public class CartDaoImpt   {
	
	@Autowired
	SessionFactory factory ;
	
	public CartDaoImpt() {
		//factory = HibernateUtil.getFactory();
	}
	
	//@Override
	public List<CartItem> carList(int id) {
		Session session = factory.getCurrentSession();
		try {
			List<CartItem> resultList = session.createQuery("from CartItem where user_id = :id",CartItem.class)
					.setParameter("id", id).getResultList();
			return resultList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//@Override
	public void addCart(CartItem cart) {
		Session session = factory.getCurrentSession();
		try {
			CourseBean courseBean = session.get(CourseBean.class, cart.getCourseBean().getCourse_id());
			MemberBean memberBean = session.get(MemberBean.class, cart.getUser_id());
			cart.setCourseBean(courseBean);
			cart.setMemberBean(memberBean);
			cart.setPrice(courseBean.getCourse_price());
			session.save(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Override
	public void deleteCart(int paseInt) {
		Session session = factory.getCurrentSession();
		try {
			CartItem cartItem = session.get(CartItem.class, paseInt);
			session.delete(cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//@Override
	public void clearCard(int userId) {
		Session session = factory.getCurrentSession();
		try {
			session.createQuery("delete from CartItem where user_id = :id")
			.setParameter("id", userId).executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public CartItem getCountTotal(List<CartItem> cart) {
		int count = 0;
		double price = 0;
		for(CartItem item : cart) {
			count += item.getCount();
			price += item.getCourseBean().getCourse_price();
		}
		if(cart.size()==0) {
			return null;
		}else {
			
			CartItem cartItem = cart.get(0);
			cartItem.setTotalCount(count);
			cartItem.setTotalPrice(price);
			return cartItem;
		}
	
	}
}
