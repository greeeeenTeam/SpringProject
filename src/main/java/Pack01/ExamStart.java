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
		int n=0;
		String sql = "select * from member where cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cn);;
			rs = pstmt.executeQuery();

			while(rs.next()){
				if(cn.equals(rs.getString("cn"))) {
					n=1;
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}try{
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			response.setContentType("text/html;charset=UTF-8");

			if(n>0){
				HttpSession session = request.getSession();
				session.setAttribute("cn", cn);
				response.sendRedirect("/SpringProject/test");
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