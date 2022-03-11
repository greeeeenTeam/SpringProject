package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamStart {
	public Boolean login(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select cn from member where name=? and rrn=?";
		//String sql2 = "select * from manager";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, rrn);
			int rs = pstmt.executeUpdate();

			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;
	}
}