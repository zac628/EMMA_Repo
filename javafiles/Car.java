import java.sql.*;

public class Car {
	public static String[] getClientCars(String email){
		String sql = "SELECT CAR1,CAR2,CAR3,CAR4,CAR5 From Client " + "WHERE EMAIL = ?";
		String[] fail = null;
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			String[] temp = {
					rs.getString("CAR1"),
					rs.getString("CAR2"),
					rs.getString("CAR3"),
					rs.getString("CAR4"),
					rs.getString("CAR5")
					};
			return temp;
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
			
			return fail;
		}
	}
	
	public static String[] getCarInfo(String email, String num){
		String sql = "SELECT * From Car " + "WHERE PLATE = ?";
		String[] fail = null;
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			String[] temp = {
					rs.getString("PLATE"),
					rs.getString("YEAR"),
					rs.getString("MAKE"),
					rs.getString("MODEL"),
					rs.getString("COLOR")
			};
			return temp;
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
			return fail;
		}
	}
	
	public static void setPlate(String desired, String current){
		String sql = "UPDATE Car SET PLATE = ?" + "WHERE PLATE = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, desired);
			pstmt.setString(2, current);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void setYear(String year, String plate){
		String sql = "UPDATE Car SET YEAR = ?" + "WHERE PLATE = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, year);
			pstmt.setString(2, plate);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	
	public static void setMake(String make, String plate){
		String sql = "UPDATE Car SET MAKE = ?" + "WHERE PLATE = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, make);
			pstmt.setString(2, plate);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	
	public static void setModel(String model, String plate){
		String sql = "UPDATE Car SET MODEL = ?" + "WHERE PLATE = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, model);
			pstmt.setString(2, plate);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	
	public static void setColor(String color, String plate){
		String sql = "UPDATE Car SET COLOR = ?" + "WHERE PLATE = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, color);
			pstmt.setString(2, plate);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
}

