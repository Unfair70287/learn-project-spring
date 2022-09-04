package fourth.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fourth.bean.ActivityBean;


@Repository
@Transactional
public class ActivityDAO {
	
	public static final String SELECT_ALL = null;
	@Autowired
	private SessionFactory factory;
	
	public ActivityDAO() {
//		SessionFactory sessionFactory = HibernateUtil.getFactory();
//		this.session = sessionFactory.getCurrentSession();
		
	}
	//輸入判斷 取得活動 
	public List<ActivityBean> selectActivities(String sqlWhere){
		Session session = factory.getCurrentSession();
		if (sqlWhere == null) {
			sqlWhere = "";
		}
		Query<ActivityBean> activities = session.createQuery("from ActivityBean "+sqlWhere, ActivityBean.class);
		return activities.list();
	}
	//輸入Id 取得活動
	public ActivityBean selectActivity(Integer id){
		Session session = factory.getCurrentSession();
		ActivityBean activityBean = session.get(ActivityBean.class, id);
		return activityBean;
	}
	
	//新增活動	
	public boolean insertActivities(ActivityBean activity) {
		Session session = factory.getCurrentSession();
		if(activity.getId() == null ) {
			session.save(activity);
			return true;
		}
		return false;
		
	}
	//刪除活動
	public boolean deleteActivities(ActivityBean activity) {
		boolean execute = deleteActivities(activity.getId());
		return execute ;
	}
	public boolean deleteActivities(Integer id) {
		Session session = factory.getCurrentSession();
		ActivityBean activityBean = session.get(ActivityBean.class, id);
		if(activityBean!= null) {
			session.delete(activityBean);
			return true;
		}
		return false;
	}
	//修改活動
	public boolean updateActivities(ActivityBean activity){
		Session session = factory.getCurrentSession();
		System.out.println(activity.toString());
		ActivityBean activityBean = session.get(ActivityBean.class, activity.getId());
		if(activityBean != null ) {
			return activityBean.upDate(activity);
		}
		return false;
	}
	

}
