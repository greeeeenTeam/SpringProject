package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	String addExam(
			@RequestParam(value="exam_question") String question,
			@RequestParam(value="ans_1") String ans_1,
			@RequestParam(value="ans_2") String ans_2,
			@RequestParam(value="ans_3") String ans_3,
			@RequestParam(value="ans_4") String ans_4,
			@RequestParam(value="answer") String answer
			) {
		
		AdminDAO.InsertProblem(question, ans_1, ans_2, ans_3, ans_4, answer);
		return "admin";
	}
	
	@RequestMapping(value = "/admin/result", method = RequestMethod.GET)
	String readResult(Model model) {
		System.out.println("시험 본 결과");
		model.addAttribute("resultList", AdminDAO.ResultList());
		return "ResultList";
	}
}
