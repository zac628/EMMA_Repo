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
		String sql = "UPDATE Client SET ADDRESS = ?" + "WHERE EMAIL = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, address);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void setNumber(String email, String number){
		String sql = "UPDATE Client SET NUMBER = ?" + "WHERE EMAIL = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, number);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void setFirst(String email, String newName){
		String sql = "UPDATE Client SET FNAME = ?" + "WHERE EMAIL = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newName);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void setLast(String email, String newName){
		String sql = "UPDATE Client SET LNAME = ?" + "WHERE EMAIL = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newName);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
