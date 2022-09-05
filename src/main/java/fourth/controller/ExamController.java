package fourth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import fourth.bean.ExamBean;
import fourth.service.ExamService;
import util.ExamUtil;


//	/ExamMainView
@Controller
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@PostMapping("/ExamController")
	public String processAction(@RequestParam("todo") String todo,Model m
			,@RequestParam(defaultValue = "") String subject,@RequestParam(defaultValue = "") String education
			,@RequestParam(defaultValue = "") String examName,@RequestParam(defaultValue = "") String examDate
			,@RequestParam(defaultValue = "") String examID,@RequestParam(required = false) ExamBean upBean) {
		
		String nextPage="";
		List<ExamBean> theExamTable= new ArrayList<ExamBean>();
		
		if (todo.equals("upload")) {

			nextPage = "ExamInsert";
			
		}else if (todo.equals("update")) {
			
			Map<String, String> memAttribute = new HashMap<String, String>();
			m.addAttribute("memAttribute", memAttribute);
			
			memAttribute.put("examID", examID);
			memAttribute.put("subject", subject);
			memAttribute.put("education", education);
			memAttribute.put("examName", examName);
			memAttribute.put("examDate", examDate);	
			
			nextPage = "ExamUpdate";
			
		}else if(todo.equals("delete")) {
			
//			System.out.println("examID"+examID);
			
			examService.delete(examID);
			
			nextPage = "Exam";
			
			
		}else if (todo.equals("query")) {
			
			theExamTable = examService.select(subject,education);
			
			m.addAttribute("examTable", theExamTable);
			
			nextPage = "Exam";
			
		}else if (todo.equals("queryAll")) {
			
			theExamTable = examService.selectAll();
			
			m.addAttribute("examTable", theExamTable);
			
			nextPage = "Exam";
			
		}else if (todo.equals("test")) {
			
	
			
			nextPage = "Exam";
			
		}else if(todo.equals("testSubmit")) {
				
		
				
			nextPage = "Exam";	
			
		}

		
		return nextPage;
	}
	
	
	@PostMapping("/InsUpController")
	public String processAction2(@RequestParam("todo") String todo,Model m
			,@RequestParam(defaultValue = "") String subject,@RequestParam(defaultValue = "") String education
			,@RequestParam(defaultValue = "") String examName,@RequestParam(defaultValue = "") String examDate
			,@RequestParam(defaultValue = "") String examID) {
		
		String nextPage="";
		List<ExamBean> theExamTable= new ArrayList<ExamBean>();
		
		if (todo.equals("insert")) {
			
			if (!ExamUtil.datacheck(examDate)){
				
				String warn = "資料錯誤";
				
				m.addAttribute("warn", warn);
				
				nextPage = "ExamInsert";
				
			}else {
				
				examService.insert(subject, education, examName, examDate);
				
				nextPage = "Exam";
			}		
			
			
		}else if (todo.equals("update")) {
			
			System.err.println("InsUpController內examID="+examID);
			
			if (!ExamUtil.datacheck(examDate)){
				
				String warn = "資料錯誤";
				m.addAttribute("warn", warn);
				
				nextPage = "ExamUpdate";
				
			}else {
				
				System.err.println(examID+subject+education+examName+examDate);
				
				examService.update(examID, subject, education, examName, examDate);
				
//				theExamTable = examService.selectAll();
				
//				m.addAttribute("examTable", theExamTable);
				
				nextPage = "Exam";
			}	
				
			
		}

		
		return nextPage;
	}
	
}
