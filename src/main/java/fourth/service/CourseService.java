package fourth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.CourseBean;
import fourth.dao.CourseDao;


@Service
@Transactional
public class CourseService  {

	@Autowired
	private CourseDao cosDao;

	
	public CourseBean insert(CourseBean cosBean) {
		CourseBean theCos = cosDao.insert(cosBean);
		return theCos;
	}
	public CourseBean select(int course_id) {
		CourseBean theCos = cosDao.select(course_id);
		return theCos;
	}
	public List<CourseBean> selectName(String course_name) {
		return cosDao.selectName(course_name);
	}
	public List<CourseBean> selectAll() {
		return cosDao.selectAll();
	}
	public CourseBean updateOne(CourseBean courseBean) {
		CourseBean theCos = cosDao.updateOne(courseBean);
		return theCos;
	}
	public boolean deleteOne(int course_id) {
		return cosDao.deleteOne(course_id);
	}



	

}
