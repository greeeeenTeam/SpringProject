package Pack01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pack01.Account;

@Controller
public class DoTestCon {
	@RequestMapping("/DoTest")
	String insertAnswer(Model model,HttpServletRequest request,String checkAnswer){
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		String answer5 = request.getParameter("answer5");
		String[] answerList = checkAnswer.split(",");
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		int count = 0;
		int pass = 0;
		
		if (answer1.equals(answerList[0])) {
			count++;
		}
		if (answer2.equals(answerList[1])) {
			count ++;
		}
		if (answer3.equals(answerList[2])) {
			count++;
		}
		if (answer4.equals(answerList[3])) {
			count ++;
		}
		if (answer5.equals(answerList[4])) {
			count++;
		}

		if(count>= 3) {
			pass = 1;
		}else {
			pass = 0;
		}
		Boolean test = dao.DoTest(cn, pass, count);
		if(test) {
			model.addAttribute("result", dao.selectResult(cn));
		}
		
		return "ResultView";
	}
}
