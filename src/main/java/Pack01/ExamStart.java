package Pack01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExamStart {
	public Boolean login(String cn, HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n=3;
		String sql = "select * from member where cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cn);;
			rs = pstmt.executeQuery();

			while(rs.next()){
				String user_name = rs.getString("name");
				String user_cn = rs.getString("cn");
				if(cn.equals(user_cn)) {
					if(request.getParameter("user_name").equals(user_name)) {
						n=1;
						break;
					} else {
						n=2;
						break;
					}
				} else {
					n=3;
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}try{
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
			System.out.println("n체크" + n);
			HttpSession session = request.getSession();
			if(n==1){
				session.setAttribute("cn", cn);
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect("/SpringProject/wait");
			} else if(n==2) {
				session.setAttribute("error", "이름과 수험번호가 일치하지 않습니다.");
				response.sendRedirect("/SpringProject/wait");
			} else if(n==3) {
				session.setAttribute("error", "존재하지 않는 수험번호 입니다.");
				response.sendRedirect("/SpringProject/wait");
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;
	}
}