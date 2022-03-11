package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCon {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value = "/admin/listexam", method = RequestMethod.GET)
	String listExam(Model model) {
		System.out.println("문제보기");
		model.addAttribute("questionList", AdminDAO.examList());
		return "ListExam";
	}
	
	@RequestMapping(value = "/admin/addexam", method = RequestMethod.GET)
	String addExamView() {
		System.out.println("문제추가페이지");
		return "AddExam";
	}
	
	@RequestMapping(value = "/admin/addexam", method = RequestMethod.POST)
	String addExam() {
		System.out.println("문제 추가 로직");
		return "admin";
	}
	
	@RequestMapping(value = "/admin/result", method = RequestMethod.GET)
	String readResult() {
		System.out.println("시험 본 결과");
		return "ResultList";
	}
}
