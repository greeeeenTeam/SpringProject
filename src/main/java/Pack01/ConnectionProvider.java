package Pack01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {

	public static Connection getConnection()
	{
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://54.144.194.195:3306/onlinetest?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "lion", "1234");

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null)
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}