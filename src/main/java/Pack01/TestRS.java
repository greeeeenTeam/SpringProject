package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Pack01.Account;

@Controller
public class TestRS {
	@RequestMapping("/DoTest")
	String func01() {
		System.out.println("dotest");
		Account dao = new Account();
		
		Boolean test = dao.DoTest("lecture");
		if(test) {
			System.out.println("db update");
		}
		return null;
	}
}
