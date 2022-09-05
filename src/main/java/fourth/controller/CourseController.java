package fourth.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.bean.CourseBean;
import fourth.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService cService;

	
	@GetMapping("/backendIndex")
	public String showBackendIndex() {
		return "BackendIndex";
	}
	
	@GetMapping("/courseList")
	public String listCourse(Model m) {
		List<CourseBean> list = cService.selectAll();
		m.addAttribute("list", list);
		return "List";

	}
	
	@GetMapping("/add")
	public String addForm() {
		return "CourseForm";
	}
	
	@PostMapping("/insert")
    public String insertCourse(@ModelAttribute("cosBean") CourseBean cosBean) {
		cosBean.setCourse_picture("images/" + cosBean.getCourse_picture());
        cService.insert(cosBean);
        return "InsertSuccess";
    }
	
	@GetMapping("/details")
	public String showDetails(int course_id,Model m) {
		CourseBean cbean = cService.select(course_id);
		m.addAttribute("cbean", cbean); 
		return "Details";
	}
	
	@GetMapping("/show")
	public String updateDetails(int course_id,Model m) {
		CourseBean bean = cService.select(course_id);
		m.addAttribute("bean", bean); 
		return "Update";
	}
	
	@PostMapping("/update")
    public String updateCourse(CourseBean courseBean) {
		System.out.println(courseBean.getCourse_picture());
        cService.updateOne(courseBean);
        return "redirect:/courseList";
    }

	@PostMapping("/queryId")
	public String queryId(@RequestParam("keyword") String keyword, Model m) {
		HashMap<String, String> errorMsgMap = new HashMap<String, String>();
		m.addAttribute("errorMsgMap", errorMsgMap);
		if (keyword == "") {
			keyword = "0";
		};
		CourseBean cb = cService.select(Integer.parseInt(keyword));
		if (keyword == "0" || cb == null) {
			errorMsgMap.put("QueryError", "<font color=red size=5>查無資料!!</font>");
		}

		if (errorMsgMap != null && !errorMsgMap.isEmpty()) {
			return "redirect:/courseList";
		}

		m.addAttribute("queryId", cb);
		return "QueryId";
	}
	
	
	@PostMapping("/queryName")
	public String queryName(@RequestParam("keyword") String keyword, Model m) {
		List<CourseBean> list = cService.selectName(keyword);
		if(keyword == "" || keyword.length() == 0) {
			return "redirect:/courseList";
		}
			m.addAttribute("queryResult", list);
			return "Query";
		
	}

	@GetMapping("/delete")
	public String delete(int course_id) {
		cService.deleteOne(course_id);
		return "redirect:/courseList";
	}

//	@GetMapping("/delete/{id}")    
//    public String delete(@PathVariable(value = "id") int course_id){    
//		cService.deleteOne(course_id);    
//        return "redirect:/courseList";    
//    }

}
