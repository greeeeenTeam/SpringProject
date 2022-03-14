package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pack01.Account;

@Controller
public class TestRS {
	@RequestMapping("/DoTest")
	String insertAnswer(Model model,HttpServletRequest request){
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		String answer5 = request.getParameter("answer5");
		String checkAnswer1 = request.getParameter("checkAnswer1");
		String checkAnswer2 = request.getParameter("checkAnswer2");
		String checkAnswer3 = request.getParameter("checkAnswer3");
		String checkAnswer4 = request.getParameter("checkAnswer4");
		String checkAnswer5 = request.getParameter("checkAnswer5");
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		int count = 0;
		int pass = 0;

		if (answer1.equals(checkAnswer1)) {
			count++;
		}
		if (answer2.equals(checkAnswer2)) {
			count ++;
		}
		if (answer3.equals(checkAnswer3)) {
			count++;
		}
		if (answer4.equals(checkAnswer4)) {
			count ++;
		}
		if (answer5.equals(checkAnswer5)) {
			count++;
		}
		
		System.out.println(count);
		if(count>= 3) {
			pass = 1;
		}else {
			pass = 0;
		}
		Boolean test = dao.DoTest(cn, pass, count);
		if(test) {
			System.out.println("시험 완료!");
		}
		return null;
	}
}
