package fourth.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.ExamEduBean;
import fourth.bean.ExamBean;
import fourth.bean.ExamSubBean;



@Repository
@Transactional
public class ExamDao  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public ExamBean insert(ExamBean examBean) {
		Session session = sessionFactory.getCurrentSession();
			session.save(examBean);
		return examBean;
	}
	
	
	
	
	public List<ExamBean> select(Integer subIdx,Integer eduIdx) {
		Session session = sessionFactory.getCurrentSession();
		ExamSubBean subBean = session.get(ExamSubBean.class, subIdx);
		ExamEduBean eduBean = session.get(ExamEduBean.class, eduIdx);
		
		String hql = "from ExamBean where subject = :subIdx and education = :eduIdx";
		
		Query<ExamBean> query = session.createQuery(hql).setParameter("subIdx", subBean)
		 .setParameter("eduIdx", eduBean);
									 
		List<ExamBean> list = query.getResultList();
		
		return list;
	}

	
	public List<ExamBean> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<ExamBean> query= session.createQuery("from ExamBean",ExamBean.class);
		
		return query.list();
	}

	
	public ExamBean update(Integer updateId, ExamBean examBean) {
		Session session = sessionFactory.getCurrentSession();
		ExamBean oldExBean = session.get(ExamBean.class, updateId);
		System.err.println("Dao內");
		System.err.println("old="+oldExBean);
		System.err.println("new="+examBean);
		
		if(oldExBean != null) {
			try {
				oldExBean.setSubject(examBean.getSubject());
				oldExBean.setEducation(examBean.getEducation());
				oldExBean.setExamName(examBean.getExamName());
				oldExBean.setExamdate(examBean.getExamdate());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return examBean;
		}
		return examBean;
	}


	
	public boolean deleteOne(Integer deleteId) {
		Session session = sessionFactory.getCurrentSession();
		ExamBean rsExBean = session.get(ExamBean.class, deleteId);
		
		if(rsExBean!=null) {
			session.delete(rsExBean);
			return true;
		}
		
		return false;
	}
}
