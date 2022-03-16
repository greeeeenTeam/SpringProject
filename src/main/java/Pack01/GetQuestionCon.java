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
		System.out.println("is progreess before");
		Boolean isInProgress = dao.isInProgress(cn);
		System.out.println("is progreess after");
		// 진행중이면 null값 찾아서 해당 페이지로 이동
		if (isInProgress) {
			//조인해서 넘겨주기 new_test랑 multiple_questin DAta
			//model.addAttribute("questionListInProgress", dao.selectQuestionInProgress(cn));
			// 첫번째 null값 찾기
			ResultSet rs = dao.selectQuestionInProgress(cn);
			
			int page = 1;
			try {
				while(rs.next()) {
					String ans = null;
					for(int i = 1; i <= 5; i++) {
						ans = rs.getString("a" + i);
						if(ans == null || ans.isEmpty()) page = i;
						response.sendRedirect("testing?page=" + page);
					}
				}
				response.sendRedirect("/SpringProject/resultPage");
//				if(page == 0) {
//					return "다시 접수해주세요.";
//				}
//				response.sendRedirect("testing?page=" + page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//진행중이 아니면 문제 new_test에 넣기
		else {
			System.out.println("문제 랜덤 생성");
			ResultSet rs = dao.selectQuestionList();
			ArrayList<String> problemList = new ArrayList<String>();
			try {
				while(rs.next()) {
					problemList.add(rs.getString("id"));
				}
				System.out.println("문제 어레이 생성 완료");
				dao.createOMR(cn, problemList);
				System.out.println("문제 추가 완료");
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
	
	@RequestMapping(value = "/wait", method = RequestMethod.GET)
	String wait(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		return "WaitView";
	}
}
