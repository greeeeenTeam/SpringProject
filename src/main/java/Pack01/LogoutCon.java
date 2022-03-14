package Pack01;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutCon extends HttpServlet {
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	String logout() {
		return "logout";
	}
	
}