package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Account;

@Controller
public class GetQuestionControl {
	@RequestMapping("/test")
	String getQuestionList(Model model) {
		Account dao = new Account();
		model.addAttribute("questionList", dao.selectQuestionList());
		return "TestView";
	}
	
	@RequestMapping("/result")
	String getResult(Model model) {
		Account dao = new Account();
		model.addAttribute("result", dao.selectResult());
		return "ResultView";
	}
}
