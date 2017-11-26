import java.sql.*;
public class Employee {

	
	public static void setUsername(String desired, String current){
		String sql = "UPDATE User SET USERNAME = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, desired);
			pstmt.setString(2, current);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	
	public static void setPassword(String password, String username){
		String sql = "UPDATE User SET PASSWORD = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setFirst(String name, String username){
		String sql = "UPDATE User SET FNAME = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setLast(String name, String username){
		String sql = "UPDATE User SET LNAME = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setDesignation(String des, String username){
		String sql = "UPDATE User SET DESIGNATION = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, des);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setRate(double rate, String username){
		String sql = "UPDATE User SET RATE = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setDouble(1, rate);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	public static Double getHours(String username){
		String sql = "SELECT HOURS From User " + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			return rs.getDouble("Hours");
		} catch(SQLException e){
			System.out.println(e.getMessage());
			return - 1.0;
		}
				
	}
	public static void setHours(double hours, String username){
		String sql = "UPDATE User SET HOURS = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setDouble(1, hours);
			pstmt.setString(2, username); 
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	public static Double getPunch(String username){
		String sql = "SELECT PUNCH From User " + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			return rs.getDouble("PUNCH");
		} catch(SQLException e){
			System.out.println(e.getMessage());
			return -1.0;
		}
				
	}
	public static void setPunch(Double dt, String username){
		String sql = "UPDATE User SET PUNCH = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setDouble(1, dt);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
}
