package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Auth;

@Controller
public class GetQuestionControl {
	@RequestMapping("/test")
	String getQuestionList(Model model) {
		Auth dao = new Auth();
		model.addAttribute("questionList", dao.selectQuestionList());
		return "TestView";
	}
}
