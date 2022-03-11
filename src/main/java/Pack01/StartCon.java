package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartCon {
	@RequestMapping(value = "/cnlogin", method = RequestMethod.POST)
	String signup(
	        @RequestParam(value="user_cn") String cn,
	        HttpServletRequest request, HttpServletResponse response) {
		System.out.println("examstart");
		ExamStart dao = new ExamStart();
		
		Boolean test = dao.login(cn, request, response);
		if(test) {
			System.out.println("db select");
		}
		StartDTO dto = new StartDTO(cn);
		
		return "examstartok";
	}
	
	@RequestMapping(value = "/cnlogin", method = RequestMethod.GET)
	   String func02() {
	      System.out.println("시험시작.");
	      return "cnlogin";
	   }
	@RequestMapping(value = "/questiontest", method = RequestMethod.GET)
	   String func03() {
	      System.out.println("시험시작.");
	      return "questiontest";
	   }
}
