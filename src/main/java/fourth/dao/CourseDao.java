package fourth.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fourth.bean.CourseBean;

@Repository
@Transactional
public class CourseDao  {

	@Autowired
	private SessionFactory factory;


	public CourseBean insert(CourseBean cosBean) {
		Session session = factory.getCurrentSession();
		CourseBean courseBean = session.get(CourseBean.class, cosBean.getCourse_id());
		if (courseBean == null) {
			session.save(cosBean);
			return cosBean;
		}
		return null;
	}

	
	public CourseBean select(int course_id) {
		Session session = factory.getCurrentSession();
		return session.get(CourseBean.class, course_id);
	}
	
	public List<CourseBean> selectName(String course_name) {
		Session session = factory.getCurrentSession();
		Query<CourseBean> queryName = session.createQuery("from CourseBean where course_name like :name", CourseBean.class)
				.setParameter("name", "%" + course_name + "%");
		return queryName.list();
	}

	public List<CourseBean> selectAll() {
		Session session = factory.getCurrentSession();
		Query<CourseBean> query = session.createQuery("from CourseBean", CourseBean.class);
		return query.list();

	}
	public CourseBean updateOne(CourseBean courseBean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(courseBean);
		return null;
	}

	public boolean deleteOne(int course_id) {
		Session session = factory.getCurrentSession();
		CourseBean courseBean = session.get(CourseBean.class, course_id);
		if (courseBean != null) {
			session.delete(courseBean);
			return true;
		}

		return false;
	}

	

}
