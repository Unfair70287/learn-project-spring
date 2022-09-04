package fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.bean.ActivityBean;
import fourth.service.ActivityService;

@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	

	// Activity get
	@GetMapping("/Activity")
	public String uerSelect(@RequestParam(required=false) String select, Model m) {
		List<ActivityBean> activities = null;
		if (select!= null ) {
			String[] yearAndMonth = select.split("-");
			if (yearAndMonth.length == 2) {
				String year = yearAndMonth[0];
				String month = yearAndMonth[1].replace("0", "");
				String where = "where (DATEPART(yy, start_time) = " + year + " AND DATEPART(mm, start_time) = " + month
						+ ")";
				activities = activityService.selectActivity(where);
			}
		}
		if (activities == null) {
			activities = activityService.selectAllActivity();
		}
		m.addAttribute("selectAllActivity", activities);

		return "Activity_User";
	}

	// Activity_OP_test get
	@GetMapping("/Activity_OP_test")
	public String test(Model m) {
		List<ActivityBean> activities = null;
		activities = activityService.selectAllActivity();

		m.addAttribute("selectAllActivity", activities);

		return "Activity_OP";
	}

	//Activity_OP post
	@PostMapping("/Activity_OP")
	public String activityOP(@RequestParam(required = false) String request, @ModelAttribute ActivityBean activityBean,
			Model m) {

		List<ActivityBean> activities = null;
		if (request != null) {
//			從讀取activityBean
			if (request.equals("Update")) {
				activityService.updateActivities(activityBean);
			} else if (request.equals("Insert")) {
				activityService.insertActivities(activityBean);
			}
		}
		if (activities == null) {
			activities = activityService.selectAllActivity();
		}

		m.addAttribute("selectAllActivity", activities);

		return "Activity_OP";

	}

	//Activity_OP get
	@GetMapping("/Activity_OP")
	public String opSelect(@RequestParam(value = "select") String select, Model m) {
		List<ActivityBean> activities = null;
		String[] yearAndMonth = select.split("-");
		if (yearAndMonth.length == 2) {
			String year = yearAndMonth[0];
			String month = yearAndMonth[1].replace("0", "");
			String where = "where (DATEPART(yy, start_time) = " + year + " AND DATEPART(mm, start_time) = " + month
					+ ")";
			activities = activityService.selectActivity(where);
		}
		if (activities == null) {
			activities = activityService.selectAllActivity();
		}
		m.addAttribute("selectAllActivity", activities);
		return "Activity_OP";
	}

	// /Activity_OP/insert post
	@PostMapping("/Activity_OP_insert")
	public String insertActivities() {
		return "ActivityInster";
	}
	
	//Activity_OP/update post
	@PostMapping("/Activity_OP_update")
	public String updateActivities(@RequestParam(required = false) String request,@ModelAttribute ActivityBean activityBean, Model m) {
		if (request != null) {
			if (request.equals("修改")) {
				System.out.println(activityBean.toString());
				m.addAttribute("activityBean", activityBean);
				return "ActivityUpdate";
			} else if (request.equals("刪除")) {
				activityService.deleteActivities(activityBean);
				
			}
		}
		activityOP(null, activityBean, m);
		return "Activity_OP";
	}

	
}
