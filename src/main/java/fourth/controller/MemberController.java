package fourth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.bean.MemberBean;
import fourth.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/backendIndex")
	public String showBackendIndex() {
		return "BackendIndex";
	}

	@RequestMapping(path = "/login.controller", method = RequestMethod.GET)
	public String loginController() {
		return "Login";
	}

	@RequestMapping(path = "/checklogin.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam("account") String account, @RequestParam("password") String password,
			Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		System.out.println(account);
		System.out.println(password);
		if (account == null || account.length() == 0) {
			errors.put("account", "<font color=red size=4 >帳號有誤!!</font>");
		}
		if (password == null || password.length() == 0) {
			errors.put("password", "<font color=red size=4 >密碼有誤!!</font>");
		}
		if (errors != null && !errors.isEmpty()) {
			return "Login";
		}
		MemberBean result = memberService.checkLogin(account, password);
		System.out.println("執行result");
		System.out.println(result);
		if (result != null) {
			if (result.getStatus() == 3) {

				return "BackendIndex";
			} else {
				return "Index";
			}

		} else {
			errors.put("msg", "<font color=red size=6 >帳號或密碼有誤!!</font>");
			return "Login";
		}
	}

	@RequestMapping(path = "/register.controller", method = RequestMethod.GET)
	public String registerController() {
		return "Register";
	}

	@RequestMapping(path = "/newRegister", method = RequestMethod.POST)
	public String newRegister(@ModelAttribute("register") MemberBean mb, BindingResult result, Model m) {
		MemberBean memberBean = new MemberBean();
		memberBean.setAccount(mb.getAccount());
		memberBean.setPassword(mb.getPassword());
		memberBean.setEmail(mb.getEmail());
		memberBean.setStatus(1);
		memberService.registerUser(memberBean);
		System.out.println("註冊會員: "+memberBean);
		m.addAttribute("register", mb);

		return "Login";
	}

	@GetMapping("/memberList")
	public String listCourse(Model m) {
		List<MemberBean> listMembers = memberService.selectAllMembers();
		System.out.println("listmembers" + listMembers);
		m.addAttribute("listMembers", listMembers);
		return "MemberList";

	}

	@GetMapping("/addNewUser")
	public String addForm() {
		return "AddNewUser";
	}

	@PostMapping("/insertNewUser")
	public String insertMember(@ModelAttribute("memberBean") MemberBean memberBean) {
		memberBean.setImg("images/" + memberBean.getImg());
		memberService.insertUser(memberBean);
		return "redirect:/memberList";
	}

	@GetMapping("/showEditUser")
	public String showEditUser(String account, Model m) {
		MemberBean existingUser = memberService.selectUserByAccount(account);
		m.addAttribute("mb", existingUser);
		return "AddNewUser";
	}

	@PostMapping("/update")
	public String updateUser(MemberBean memberBean) {
		memberBean.setImg("images/" + memberBean.getImg());
		memberService.updateUser(memberBean);
		return "redirect:/memberList";
	}

	@PostMapping("/queryAccount")
	public String queryAccount(@RequestParam("keyword_account") String account, Model m) {
		HashMap<String, String> errorMsgMap = new HashMap<String, String>();
		m.addAttribute("errorMsgMap", errorMsgMap);
		List<MemberBean> list = memberService.QueryUserByAccount(account);
		System.out.println("queryList:" + list);
		if (list.isEmpty()) {
			errorMsgMap.put("QueryError", "<font color=red size=5>查無此帳號!!</font>");
			return "redirect:/memberList";
		} else {
			m.addAttribute("queryResult", list);
			return "QueryMemberByAccount";
		}

	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("account") String account, Model m) {
		memberService.deleteUser(account);
		return "redirect:/memberList";
	}

}
