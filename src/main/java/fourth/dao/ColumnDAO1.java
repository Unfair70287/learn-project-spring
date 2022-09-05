package fourth.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fourth.bean.ColumnBean;
//import util.HibernateUtil;

@Repository
@Transactional
public class ColumnDAO1 {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public ColumnDAO1() {
//		 factory = HibernateUtil.getSessionFactory();
	}
	public boolean insertColumn(ColumnBean column) {
//		this.session = factory.getCurrentSession();
		Session session = sessionFactory.openSession();
		try {
			ColumnBean col = session.get(ColumnBean.class, column.getArticle_no());
			if (col == null) {
				
				session.save(column);
				System.out.println("新增成功~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ColumnBean updateColumn(ColumnBean column) {
//		this.session = factory.getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Dao Update session.getId為"+ column.getArticle_no());
		ColumnBean col = session.get(ColumnBean.class, column.getArticle_no());
		if (col != null) {

			col.setPublish_time(column.getPublish_time());
			col.setUser_id(column.getUser_id());
			col.setAuthor(column.getAuthor());
			col.setRole(column.getRole());
			col.setContents(column.getContents());
			System.out.println(col.toString());
			session.save(col);
			return col;
		}
		
		return null;
	}

	public ColumnBean selectByArticleNo(int article_no) {
		//this.session = factory.getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		return session.get(ColumnBean.class, article_no);

	}

	public List<ColumnBean> selectAllColumns() {
		//this.session = factory.getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		Query<ColumnBean> query = session.createQuery("from ColumnBean", ColumnBean.class);
		return query.list();
	}

	public boolean deleteColumnByNo(int article_no) {
		//this.session = factory.getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		ColumnBean col = session.get(ColumnBean.class, article_no);
		if (col != null) {
			session.delete(col);
			return true;
		}
		return false;
	}

}
