package Pack01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pack01.Account;

@Controller
public class DoTestCon {
	@RequestMapping("/DoTest")
	void insertAnswer(Model model,HttpServletRequest request,HttpServletResponse response){
		String answer = request.getParameter("answer");
		String checkAnswer = request.getParameter("checkAnswer");
		String score = request.getParameter("score");
		String page = request.getParameter("page");
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		
		dao.updateAnswer(cn, page, answer);
		if(answer.equals(checkAnswer)) {
			dao.updateScore(cn);
		}
		try {
			if(page.equals("5")) {
				response.sendRedirect("resultPage");
			} else {
				response.sendRedirect("testing?page=" + (Integer.parseInt(page)+1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
