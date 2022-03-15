package Pack01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartCon {
	@RequestMapping(value = "/cnlogin", method = RequestMethod.POST)
//	String signup(
	// 로그인 기능
	void signup(
	        @RequestParam(value="user_cn") String cn,
	        HttpServletRequest request, HttpServletResponse response) {
		ExamStart dao = new ExamStart();
		
		if(request.getParameter("user_name").equals("admin") && request.getParameter("user_cn").equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("cn", cn);
			try {
				response.sendRedirect("admin");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Boolean test = dao.login(cn, request, response);
		if(test) {
			System.out.println("db select");
		} 
		//StartDTO dto = new StartDTO(cn);
//		return "findcn";
	}
	
	@RequestMapping(value = "/cnlogin", method = RequestMethod.GET)
	   String func02() {
	      System.out.println("시험시작.");
	      return "cnlogin";
	   }
}
