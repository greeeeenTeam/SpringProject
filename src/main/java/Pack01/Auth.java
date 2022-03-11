package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
	public Boolean login(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member values(?, ?, NULL, 0)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "김익한");
			pstmt.setString(2, "950831");
			int rs = pstmt.executeUpdate();

			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try{
	            if(pstmt!=null) pstmt.close();
	            if(conn!=null) conn.close();
	         }catch(SQLException se){
	            System.out.println(se.getMessage());
	         }
		}
		return false;
	}
}