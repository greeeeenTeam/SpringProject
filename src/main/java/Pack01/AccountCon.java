package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountCon {
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	String signup(
			@RequestParam(value="user_name") String name,
	        @RequestParam(value="user_rrn") String rrn) {
		System.out.println("signup");
		Account dao = new Account();
		
		Boolean test = dao.login(name, rrn);
		if(test) {
			System.out.println("db update");
		}
		//AccountDTO dto = new AccountDTO(name, rrn);
		
		return "signupok";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	   String func02() {
	      System.out.println("접속함.");
	      return "signup";
	   }
	
	@RequestMapping(value = "/signupok", method = RequestMethod.POST)
	String signupok(
			@RequestParam(value="user_name") String name,
	        @RequestParam(value="user_rrn") String rrn,
	        Model model) {
		System.out.println("signup");
		Account dao = new Account();
		
		//String test = dao.showrn(name, rrn);
		String cn= dao.showrn(name,rrn);
		model.addAttribute("cn", cn);
		System.out.println(cn);
		return "signupok";
	}
	
	@RequestMapping(value = "/signupok", method = RequestMethod.GET)
	String func03() {
		System.out.println("전송함.");
		return "signupok";
	}
}
