package fourth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fourth.bean.ActivityBean;
import fourth.service.ActivityService;



/**
 * Servlet implementation class Activity_OP
 */
@WebServlet("/Activity_OP")
public class ActivityServlet_OP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivityServlet_OP() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			request.setCharacterEncoding("UTF-8");
			ActivityService activityService = new ActivityService();
			// 判斷請求

			List<ActivityBean> activities = null;
			if (request.getParameter("request") != null) {
//				從讀取activityBean
				ActivityBean activityBean = activityService.readActivity(request, response);
				
				
				
				
				if (request.getParameter("request").equals("修改")) {
//					activityBean寫入該次請求
					request.setAttribute("activityBean", activityBean);
//					將請求傳送給ActivityUpdate.jsp
					request.getRequestDispatcher("ActivityUpdate.jsp").forward(request, response);
					return;
				} else if (request.getParameter("request").equals("新增")) {
					request.getRequestDispatcher("ActivityInster.jsp").forward(request, response);
					return;
				} else if (request.getParameter("request").equals("Update")) {
					System.out.println("修改");
					activityService.updateActivities(activityBean);
				} else if (request.getParameter("request").equals("Insert")) {
					activityService.insertActivities(activityBean);
				} else if (request.getParameter("request").equals("刪除")) {
					activityService.deleteActivities(activityBean);
				} else if (request.getParameter("request").equals("查詢")) {
					String[] yearAndMonth = request.getParameter("select").split("-");
					if (yearAndMonth.length == 2) {
						String year = yearAndMonth[0];
						String month = yearAndMonth[1].replace("0", "");
						String where = "where (DATEPART(yy, start_time) = " + year + " AND DATEPART(mm, start_time) = "
								+ month + ")";
						activities = activityService.selectActivity(where);
					}
				}
			}
			if (activities == null) {
				activities = activityService.selectAllActivity();
			}

			HttpSession session = request.getSession();
			session.setAttribute("selectAllActivity", activities);
			request.getRequestDispatcher("Activity_OP.jsp").forward(request, response);
			
		 
	}
}
