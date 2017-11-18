import java.sql.*;
import java.util.*;

public class ClientOperations{

	
	public static void setEmail(String current, String desired){
		String sql = "UPDATE Client SET EMAIL = ?" + "WHERE EMAIL = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, desired);
			pstmt.setString(2, current);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setAddress(String email, String address){
		//Search DB for client by email then change address
	}
	
	public static void setNumber(String email, String number){
		//Search in DB for client by email then change number
	}
	
	public static void setFirst(String email, String newName){
		
	}
	
	public static void setLast(String email, String newName){
		
	}
}
