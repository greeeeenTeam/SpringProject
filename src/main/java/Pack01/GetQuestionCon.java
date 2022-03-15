package Pack01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Pack01.Account;

@Controller
public class GetQuestionCon {
	@RequestMapping("/test")
	void getQuestionList(Model model, HttpServletResponse response, HttpServletRequest request) {
		Account dao = new Account();
		
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		// 진행중인지 판별
		Boolean isInProgress = dao.isInProgress(cn);
		// 진행중이면 null값 찾아서 해당 페이지로 이동
		if (isInProgress) {
			//조인해서 넘겨주기 new_test랑 multiple_questin DAta
			//model.addAttribute("questionListInProgress", dao.selectQuestionInProgress(cn));
			// 첫번째 null값 찾기
			ResultSet rs = dao.selectQuestionInProgress(cn);
			
			int page = 1;
			try {
				System.out.println("거의 다 옴");
				while(rs.next()) {
					String a1 = rs.getString("a1");
					String a2 = rs.getString("a2");
					String a3 = rs.getString("a3");
					String a4 = rs.getString("a4");
					String a5 = rs.getString("a5");
					if(a1==null || a1.isEmpty()) page = 1;
					else if(a2==null || a2.isEmpty()) page = 2;
					else if(a3==null || a3.isEmpty()) page = 3;
					else if(a4==null || a4.isEmpty()) page = 4;
					else if(a5==null || a5.isEmpty()) page = 5;
				}
				response.sendRedirect("testing?page=" + page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//진행중이 아니면 문제 new_test에 넣기
		else {
			// model.addAttribute("questionList", dao.selectQuestionList());
			ResultSet rs = dao.selectQuestionList();
			ArrayList<String> problemList = new ArrayList<String>();
			try {
				while(rs.next()) {
					problemList.add(rs.getString("id"));
				}
				dao.createOMR(cn, problemList);
				dao.updateFlag(cn, "1");
				response.sendRedirect("test");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		return "TestView";
	}
	
	@RequestMapping("/result")
	String getResult(Model model,HttpServletRequest request) {
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		model.addAttribute("result", dao.selectResult(cn));
		return "ResultView";
	}
	
	@RequestMapping(value = "/testing", method = RequestMethod.GET)
	String getResult(Model model, @RequestParam("page") String page, HttpServletRequest request) {
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		//String qNum = dao.getQuestion(cn, page);
		//model.addAttribute("result", dao.getQuestion(qNum));
		model.addAttribute("result",dao.getQuestion(cn, page));
		return "TestView";
	}
	
	/*
	 * @RequestMapping(value = "/testing", method = RequestMethod.POST) String
	 * updateResult(Model model, @RequestParam("page") String page,
	 * HttpServletRequest request) { String answer1 =
	 * request.getParameter("answer1"); Account dao = new Account(); HttpSession
	 * session = request.getSession(); String cn
	 * =(String)session.getAttribute("cn"); String qNum = dao.getQuestion(cn, page);
	 * model.addAttribute("result", dao.getQuestion(qNum)); return "TestView"; }
	 */
}
