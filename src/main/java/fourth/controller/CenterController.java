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
	
	
	
	@GetMapping("/backendIndex")
	public String showBackendIndex() {
		return "BackendIndex";
	}
	@GetMapping("/Index")
	public String Index() {
		return "Index";
	}
	

	
}
