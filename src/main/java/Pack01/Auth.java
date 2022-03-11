package Pack01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Auth {
   public Boolean isMember(String id, String pwd)
   {
      Boolean isCheck = null;
      
      String sql = "SELECT exists (select * from user where id=? and pwd=?) as isMember;";
      try {
         Connection conn = ConnectionProvider.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, id);
         pstmt.setString(2, pwd);
         ResultSet rs = pstmt.executeQuery();

         if(rs.next())
         {
            isCheck = rs.getBoolean(1);
         }
         
      }catch (Exception e) {
         // TODO: handle exception
         System.out.println(e.getMessage());
      }
      return isCheck;
   }
   
   public Boolean login(String name, String rrn) {
	   String sql = "INSERT INTO member values(?, ?, NULL, 0)";
	   try {
	         Connection conn = ConnectionProvider.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);

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
	      }
	      return false;
   }
}