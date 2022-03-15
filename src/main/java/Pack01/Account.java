package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Account {
	public Boolean login(String name, String rrn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member values(?, ?, NULL, 0, 0)";
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
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ResultSet selectResult(String cn) {
		String sql = "select pass, result from test_result where cn=?;";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cn));
			rs = pstmt.executeQuery();
			return rs;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Boolean DoTest(String cn, int pass, String count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "INSERT INTO test_result values(null,?,?,?)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cn));
			pstmt.setInt(2,pass);
			pstmt.setString(3,count);
			
			int rs = pstmt.executeUpdate();

			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;
	}
	
	public Boolean isInProgress(String cn) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select flag from member where cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(cn));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("flag").equals("1"))	return true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;
	}
	
	public ResultSet selectQuestionInProgress(String cn) {
		String sql = "select * from new_test where cn=?;";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cn));
			rs = pstmt.executeQuery();
			return rs;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Boolean createOMR(String cn, ArrayList<String> proList) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "INSERT INTO new_test values(null, ?, ?, null, ?, null, ?, null, ?, null, ?, null, 0)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cn));
			for(int i = 0; i < proList.size(); i++) {
				pstmt.setInt(i+2, Integer.parseInt(proList.get(i)));
			}
			
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
	
	public Boolean updateFlag(String cn, String onOff) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE member SET flag=? WHERE cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, onOff);
			pstmt.setString(2, cn);
			
			int rs = pstmt.executeUpdate();
			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;		
	}
	
	public ResultSet getQuestion(String cn, String page) {
		//String sql = "select * from new_test where cn=?;";
		String sql = "select * from new_test nt join multiple_question mq on nt.q"+ page +" = mq.id where cn=?;";
		String result = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cn);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("q" + page));
//				result = rs.getString("q" + page);
//			}
			return rs;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
//	public ResultSet getQuestion(String qIdx) {
//		System.out.println("문제 찾는중");
//		String sql = "select * from multiple_question WHERE id=?";
//		Connection conn = null;
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = ConnectionProvider.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, qIdx);
//			rs = pstmt.executeQuery();
//			return rs;
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		return null; 
//	}
	
	public Boolean updateResult(String cn, String page, String answer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE new_test SET ?=? WHERE cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "a"+page);
			pstmt.setString(2, answer);
			pstmt.setString(3, cn);
			
			int rs = pstmt.executeUpdate();
			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;	
	}
	public Boolean updateScore(String cn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE new_test SET score=score+1 WHERE cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cn);
			
			int rs = pstmt.executeUpdate();
			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;	
	}
	public Boolean updateAnswer(String cn, String page,String answer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE new_test SET a" + page + " = ? WHERE cn=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, answer);
			pstmt.setString(2, cn);
			
			int rs = pstmt.executeUpdate();
			if(rs>=1)
			{
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			ConnectionProvider.close(null, pstmt, conn);
		}
		return false;	
	}
	
}