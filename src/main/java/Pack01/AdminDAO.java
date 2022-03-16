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
	
	public static ResultSet ExamGet(String getId) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM multiple_question WHERE id = ?";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, getId);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Boolean InsertProblem(String question, String ans_1, String ans_2, String ans_3, String ans_4, String answer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO multiple_question values(NULL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.setString(2, ans_1);
			pstmt.setString(3, ans_2);
			pstmt.setString(4, ans_3);
			pstmt.setString(5, ans_4);
			pstmt.setString(6, answer);
			
			int rs = pstmt.executeUpdate();
			
			if (rs >= 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;
	}
	
	public static ResultSet ResultList() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM test_result";
		
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
	
	public static Boolean UpdateExam(String updateId, String question, String ans_1,
			String ans_2, String ans_3, String ans_4, String answer
			) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE multiple_question SET question=?, ex_1=?, ex_2=?, ex_3=?, ex_4=?, answer=? WHERE id=?";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.setString(2, ans_1);
			pstmt.setString(3, ans_2);
			pstmt.setString(4, ans_3);
			pstmt.setString(5, ans_4);
			pstmt.setString(6, answer);
			pstmt.setString(7, updateId);
			
			int r = pstmt.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean DeleteExam(String deleteId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM multiple_question WHERE id = ?";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			
			int r = pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		
		return false;
	}
}
