package fourth.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fourth.bean.ColumnBean;
import fourth.dao.ColumnDAO1;
import fourth.service.ColumnService;

@Controller
@Transactional
public class ColumnController {
	
	@Autowired
	SessionFactory sessionFactory ;
	
	@Autowired
	ColumnService columnService;
	
	@GetMapping("/ColumnAdd")
	public String addJsp() {
		return "ColumnAdd";
	}
	@PostMapping("/ColumnAddAction")
	public String addAction(@RequestParam(required = false)String backToQuery , ColumnBean bean){
		if(backToQuery!= null) {
			return "redirect:QueryAll";
		}
		columnService.insertColumn(bean);
		return "redirect:QueryAll";
		
		
	}
	@GetMapping("/QueryAll")
	public String queryAllAction(Model m) {
		List<ColumnBean> selectAllColumns = columnService.selectAllColumns();
		m.addAttribute("queryall", selectAllColumns);
		return "ColumnQueryAll";
	}
	@PostMapping("/ColumnDelete")
	public String delete(int article_no) {
		columnService.deleteColumnByNo(article_no);
		return "redirect:QueryAll";
	}
	@GetMapping("/Update")
	public String update(ColumnBean bean) {
		return "ColumnUpdate"; 
	}
	@PostMapping("/updateAction")
	public String updateAction(ColumnBean bean) {
		columnService.updateColumn(bean);
		return "redirect:QueryAll";
	}
	@PostMapping("/searchAction")
	public String search(@RequestParam("search") int article_no, Model m) {
		ColumnBean col = columnService.selectByArticleNo(article_no);
		m.addAttribute("column", col);
		return queryAllAction(m);
	}
	@RequestMapping(path="/more", method=RequestMethod.POST)
	public String more(int article_no, Model m) {
		ColumnBean col = columnService.selectByArticleNo(article_no);
		m.addAttribute("col", col);
		return "ColumnMoreContents";
	}
}
