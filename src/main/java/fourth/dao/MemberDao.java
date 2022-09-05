package fourth.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.CartItem;
import fourth.bean.MemberBean;

@Repository
@Transactional
public class MemberDao {

	@Autowired
	private SessionFactory factory;
	
	@Autowired
	DataSource dataSource;
	public MemberDao() {
		//this.factory = HibernateUtil.getFactory();
	}

	public MemberBean queryAccountAndPassword(String account, String password)  {
		try {
			Session session = factory.getCurrentSession();
			
			String hql = "from MemberBean m where m.account = :account and m.password = :password";
			MemberBean result = session.createQuery(hql, MemberBean.class).setParameter("account", account)
					.setParameter("password", password).getSingleResult();
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	// 新增使用者
	public MemberBean insertUser(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		session.save(memberBean);
		return memberBean;
	}

//	//查詢所有會員
	public List<MemberBean> selectAllMembers() {
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery("from MemberBean", MemberBean.class);
		return query.list();
	}

//	
//	//刪除(透過帳號)
	public boolean deleteUser(String account) {
		Session session = factory.getCurrentSession();
		String hql = "from MemberBean m where m.account = :account ";
		try {
			MemberBean memberBean = session.createQuery(hql, MemberBean.class).setParameter("account", account)
					.getSingleResult();

			if (memberBean != null) {
				session.delete(memberBean);

				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

//	//查詢(先找帳號)
	public MemberBean selectUserByAccount(String account) {
		Session session = factory.getCurrentSession();
		String hql = "from MemberBean m where m.account = :account ";

		try {
			MemberBean result = session.createQuery(hql, MemberBean.class).setParameter("account", account)
					.getSingleResult();
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

//	//修改
	public MemberBean updateUser(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(memberBean);
		return memberBean;

	}

	// 註冊
	public MemberBean newRegister(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		session.save(memberBean);
		return memberBean;

	}

	//透過帳號查詢(list)
	public List<MemberBean> QueryUserByAccount(String account) {
		Session session = factory.getCurrentSession();
		Query<MemberBean> queryAccount=session.createQuery("from MemberBean where account like :account",MemberBean.class)
			   .setParameter("account",  "%"+account+ "%");
		return queryAccount.list();
		
	}
}