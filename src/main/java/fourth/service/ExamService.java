package fourth.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.ExamEduBean;
import fourth.bean.ExamQuesBean;
import fourth.bean.ExamBean;
import fourth.bean.ExamSubBean;
import fourth.dao.ExamDao;
import fourth.dao.ExamDaoInterface;
import fourth.util.ExamUtil;

@Service
@Transactional
public class ExamService  {
	
	@Autowired
	private ExamDao examDao;

	
	//增加
	public ExamBean insert(String subString,String eduString,String examName,String examDate){
		
		
		ExamSubBean subBean = new ExamSubBean(ExamUtil.getSubIdx(subString), subString);
		ExamEduBean eduBean = new ExamEduBean(ExamUtil.getEduIdx(eduString), eduString);
		
//		System.out.println(ExamUtil.getSubIdx(subString)+subString);
//		System.out.println(ExamUtil.getEduIdx(eduString)+eduString);
		
		ExamBean insBean = new ExamBean();
		
		try {
			
			Date tDate = new SimpleDateFormat("yyyy-MM-dd").parse(examDate);
			insBean = new ExamBean(subBean, eduBean, examName, tDate); 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return examDao.insert(insBean);
		
	}
	
	//修改
	public ExamBean update(String updateId, String subString,String eduString,String examName,String examDate){
		
		
		Integer upId = Integer.valueOf(updateId);
		ExamSubBean subBean = new ExamSubBean(ExamUtil.getSubIdx(subString), subString);
		ExamEduBean eduBean = new ExamEduBean(ExamUtil.getEduIdx(eduString), eduString);
		
//		System.out.println(ExamUtil.getSubIdx(subString)+subString);
//		System.out.println(ExamUtil.getEduIdx(eduString)+eduString);
		
		ExamBean upBean = new ExamBean();
		
		try {
			
			Date tDate = new SimpleDateFormat("yyyy-MM-dd").parse(examDate);
			upBean = new ExamBean(subBean, eduBean, examName, tDate); 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.err.println("service內");
//		System.err.println(upBean);
		return examDao.update(upId, upBean);
		
	}
	
	//查詢考卷
	public List<ExamBean> select(String subString,String eduString){
		
		
		Integer subIdx = ExamUtil.getSubIdx(subString);
		Integer eduIdx = ExamUtil.getEduIdx(eduString);
		return examDao.select(subIdx,eduIdx);
		
	}
	
	//查詢考試題目
	public List<ExamQuesBean> selectQu(String subString,String eduString){
		
		
		Integer subIdx = ExamUtil.getSubIdx(subString);
		Integer eduIdx = ExamUtil.getEduIdx(eduString);
		return examDao.selectQu(subIdx,eduIdx);
		
	}
	
	
	
	//查詢全部
	public List<ExamBean> selectAll(){
		
		return examDao.selectAll();
		
	}
	
	
	
	//刪除
	public boolean delete(String id){
				
		Integer examID = Integer.valueOf(id);
		
		return examDao.deleteOne(examID);
		
	}
	
	
}
