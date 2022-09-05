package fourth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fourth.bean.MemberBean;
import fourth.service.MemberService;

@Controller
@SessionAttributes(names = {"user"})
public class CenterController {
	
	@Autowired
	private MemberService memberService ;
	
	@GetMapping("/")
	public String enter() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String login(Model m ,String account ,String password) {
		System.out.println(account);
		System.out.println(password);
		MemberBean user = memberService.checkLogin(account, password);
		System.out.println(user);
		if(user != null) {
			if(user.getStatus() == 3) {
				m.addAttribute("user",user);
				return "BackendIndex";
			}else {
				m.addAttribute("user",user);
				return "Index";
			}
		}
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "Login";
	}
	
	@GetMapping("/backendIndex")
	public String showBackendIndex() {
		return "BackendIndex";
	}
	@GetMapping("/Index")
	public String Index() {
		return "Index";
	}
}
