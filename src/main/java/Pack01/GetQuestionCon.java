package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Account;

@Controller
public class GetQuestionCon {
	@RequestMapping("/test")
	String getQuestionList(Model model) {
		Account dao = new Account();
		model.addAttribute("questionList", dao.selectQuestionList());
		return "TestView";
	}
	
	@RequestMapping("/result")
	String getResult(Model model,HttpServletRequest request) {
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		model.addAttribute("result", dao.selectResult(cn));
		return "ResultView";
	}
}
