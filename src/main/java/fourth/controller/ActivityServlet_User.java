package fourth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fourth.bean.ActivityBean;
import fourth.service.ActivityService;




/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/Activity")
public class ActivityServlet_User extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataSource ds = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		ActivityService activityService = new ActivityService();

		List<ActivityBean> activities = null;

		if (req.getParameter("request") != null && req.getParameter("request").equals("查詢")) {
			String[] yearAndMonth = req.getParameter("select").split("-");
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
		req.setAttribute("selectAllActivity", activities);
		req.getRequestDispatcher("Activity_User.jsp").forward(req, resp);

	}

}