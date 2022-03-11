package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Pack01.Auth;

@Controller
public class TestRS {
	@RequestMapping("/DoTest")
	String func01() {
		System.out.println("dotest");
		Auth dao = new Auth();
		
		Boolean test = dao.DoTest("lecture");
		if(test) {
			System.out.println("db update");
		}
		return null;
	}
}
