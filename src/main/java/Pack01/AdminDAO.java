package Pack01;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDAO {
	public static ResultSet examList() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM multiple_question";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
