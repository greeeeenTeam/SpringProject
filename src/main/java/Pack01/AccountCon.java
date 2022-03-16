package Pack01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	        @RequestParam(value="user_rrn") String rrn,
	        Model model) {
		Account dao = new Account();
		
		Integer test = dao.login(name, rrn);
		if(test == 200) {
			System.out.println("db update");
			String cn= dao.showrn(name,rrn);
			model.addAttribute("cn", cn);
			return "signupok";
		} else if(test == 300) {
			System.out.println("이미 존재 함.");
			String cn= dao.sameRrn(rrn);
			model.addAttribute("cn", cn);
			return  "Error2";
		}
		String cn= dao.showrn(name,rrn);
		model.addAttribute("cn", cn);
		System.out.println(cn);
		return "signupok";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	   String func02() {
	      System.out.println("접속함.");
	      return "signup";
	}
	@RequestMapping(value = "/findcn", method = RequestMethod.POST)
	String test(
			@RequestParam(value="user_name") String name,
	        @RequestParam(value="user_rrn") String rrn,
	        Model model) {
		System.out.println("signup");
		Account dao = new Account();
		
		String cn= dao.showrn(name,rrn);
		model.addAttribute("cn", cn);
		System.out.println(cn);
		
		return "signupok";
	}
	
	@RequestMapping(value = "/findcn", method = RequestMethod.GET)
	   String func03() {
	      System.out.println("접속함.");
	      return "findcn";
	}
	
	
	
}
