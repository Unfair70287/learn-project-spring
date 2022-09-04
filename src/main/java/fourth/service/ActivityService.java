package fourth.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.ActivityBean;
import fourth.dao.ActivityDAO;



@Service
@Transactional
public class ActivityService {
	
	@Autowired
	private ActivityDAO activityDAO;

	public ActivityService() {
		this.activityDAO = new ActivityDAO();
	}
	//顯示所有活動
	public List<ActivityBean> selectAllActivity() {
		List<ActivityBean> activityBeans = activityDAO.selectActivities(ActivityDAO.SELECT_ALL);
		return activityBeans;
	}
	//顯示有條件之活動
	public List<ActivityBean> selectActivity(String SQLwhere) {
		List<ActivityBean> activityBeans = activityDAO.selectActivities(SQLwhere);
		return activityBeans;
	}
	//新增活動資料
	public boolean insertActivities(ActivityBean activity) {
			if(activity!=null) {
				return activityDAO.insertActivities(activity);	
			}
			return false;
	}

	// 調用資料庫刪除活動
	public boolean deleteActivities(ActivityBean activity) {
		Integer id = activity.getId();
		if(id!=null) {
			boolean deleteActivities = activityDAO.deleteActivities(id);
			return deleteActivities;
		}
		return false;
	}

	// 調用資料庫更新活動
	public boolean updateActivities(ActivityBean activity) {
		if(activity!=null) {
			return activityDAO.updateActivities(activity);
		}
		return false;
	}

	// 在request裡，讀出做成"活動物件"
	public ActivityBean readActivity(HttpServletRequest request, HttpServletResponse response) {

//		確認是否為空
		if (request.getParameter("activity_id") != null||request.getParameter("activity_title") != null) {
//			創建ActivityBean物件
			ActivityBean activity = new ActivityBean();
//			request取值給予物件
			if(request.getParameter("activity_id")!= null) {
				activity.setId(Integer.valueOf(request.getParameter("activity_id")));
			}
			activity.setTitle(request.getParameter("activity_title"));
			activity.setContent(request.getParameter("activity_content"));
			activity.setStart_time(request.getParameter("activity_start_time").replace("T", " "));
			activity.setEnd_time(request.getParameter("activity_end_time").replace("T", " "));
			activity.setImgPath(request.getParameter("activity_imgPath"));
//			回傳物件物件
			return activity;
		}
		return null;
	}

}
