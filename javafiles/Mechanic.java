import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mechanic {
	public static void shiftOrders(String u){
		String sql = "SELECT WO1,WO2,WO3,WO4 From Mechanic " + "WHERE USERNAME = ?";
		int[] values = new int[4];
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, u);
			ResultSet rs = pstmt.executeQuery();
			
					values[0] = rs.getInt("WO1");
					values[1] = rs.getInt("WO2");
					values[2] = rs.getInt("WO3");
					values[3] = rs.getInt("WO4");
					
			
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		String sql2 = "UPDATE Mechanic WO2 = ?, WO3 = ?, WO4 = ?, WO5 = ?" + "WHERE Username = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql2);){
					pstmt.setInt(1, values[0]);
					pstmt.setInt(2, values[1]);
					pstmt.setInt(3, values[2]);
					pstmt.setInt(4, values[3]);
					pstmt.setString(5, u);
					pstmt.executeUpdate();
				} catch(SQLException e){
					System.out.println(e.getMessage());
				}
	}
	
	public static String[] getOrders(String plate){
		String sql = "SELECT WO1,WO2,WO3,WO4,WO5 From Mechanic " + "WHERE USERNAME = ?";
		String[] fail = null;
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, plate);
			ResultSet rs = pstmt.executeQuery();
			String[] temp = {
					rs.getString("WO1"),
					rs.getString("WO2"),
					rs.getString("WO3"),
					rs.getString("WO4"),
					rs.getString("WO5")
					};
			return temp;
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
			
			return fail;
		}
	}
	
	public static void insert(String u) {
        String sql = "INSERT INTO Mechanic(USERNAME) VALUES(?)";
	        try (Connection conn = DriverManager.getConnection(DBTools.url);
	                PreparedStatement pstmt = conn.prepareStatement(sql)){
	            pstmt.setString(1, u);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
        
    }
	
	public static void setUsername(String desired, String current){
		String sql = "UPDATE Mechanic SET USERNAME = ?" + "WHERE USERNAME = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, desired);
			pstmt.setString(2, current);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}

}
