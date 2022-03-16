package Pack01;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultCon {
	@RequestMapping("/resultPage")
	String getResult(Model model,HttpServletRequest request,HttpServletResponse response){
		//String  = request.getParameter("");
		System.out.println("resultpage");
		Account dao = new Account();
		HttpSession session = request.getSession(); 
		String cn =(String)session.getAttribute("cn");
		ResultSet rs = dao.selectQuestionInProgress(cn);
		// score 가져오고 score가 3보다 크면 pass
		int pass = 0;
		String score;
		try {
			while(rs.next()) {
				score = rs.getString("score");
				if (Integer.parseInt(score)>3) {
					pass = 1;
				}else {
					pass = 0;
				}
				Boolean test = dao.DoTest(cn, pass, score);
				if(test) {
					model.addAttribute("result", dao.selectResult(cn));
					dao.updateFlag(cn, "2");	// 시험 종료되면 플래그 2로 올리기
					System.out.println("flag update");
				}
				return "ResultView";
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Error";
	}
	
	@RequestMapping("/directResult")
	   String getResult(Model model,HttpServletRequest request){
	      //String  = request.getParameter("");
	      Account dao = new Account();
	      HttpSession session = request.getSession(); 
	      String cn =(String)session.getAttribute("cn");
//	      ResultSet rs = dao.selectQuestionInProgress(cn);
	      model.addAttribute("result", dao.selectResult(cn));
			/*
			 * try { while(rs.next()) { // ResultSet test = dao.selectResult(cn); // if(test
			 * != null) { model.addAttribute("result", dao.selectResult(cn)); // } } return
			 * "directResultView"; } catch (NumberFormatException e) { e.printStackTrace();
			 * } catch (SQLException e) { e.printStackTrace(); }
			 */
	      return "directResultView";
	   }
}
