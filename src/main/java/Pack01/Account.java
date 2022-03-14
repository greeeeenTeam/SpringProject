package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
	public Boolean login(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member values(?, ?, NULL, 0)";
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
	
	public String showrn(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cn = null;
		String sql = "SELECT cn FROM member WHERE name = ? and rrn = ?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, rrn);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cn = rs.getString("cn");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return cn;
	}
	
	public ResultSet selectQuestionList() {
		String sql = "select * from multiple_question order by rand() limit 5;";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ResultSet selectResult() {
		String sql = "select pass, result from test_result where cn=?;";
		Connection conn = null;
		ResultSet rs = null;
		int cn = 1008;
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cn);
			rs = pstmt.executeQuery();
			return rs;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

		public Boolean DoTest(String lecture) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO test values(?)";
			try {
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, lecture);
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