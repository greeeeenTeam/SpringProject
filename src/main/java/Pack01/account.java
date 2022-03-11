package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Auth;

@Controller
public class account {
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	String signup(
			@RequestParam(value="user_name") String name,
	        @RequestParam(value="user_rrn") String rrn) {
		System.out.println("signup");
		Auth dao = new Auth();
		
		Boolean test = dao.login(name, rrn);
		if(test) {
			System.out.println("db update");
		}
		loginDTO dto = new loginDTO(name, rrn);
		
		return "signupok";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	   String func02() {
	      System.out.println("접속함.");
	      return "signup";
	   }
}
