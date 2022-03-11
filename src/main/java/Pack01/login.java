package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Auth;

@Controller
public class login {
	@RequestMapping("/survey")
	String func01() {
		System.out.println("survey");
		Auth dao = new Auth();
		
		Boolean test = dao.login("김익한", "950831");
		if(test) {
			System.out.println("db update");
		}
//		DTO dto = new DTO(name, age, phone, living_region, role, tool, wts);
//		Boolean tt = aut.setSurvey(dto);
//		if (tt == true) {
//			model.addAttribute("surveyList", aut.getSurveyList());
//			return "SurveyResultView";
//		}
		return null;
	}
}
