import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkOrder {
	
	public static String[] getOrders(String plate){
		String sql = "SELECT WO1,WO2,WO3,WO4,WO5 From CAR " + "WHERE PLATE = ?";
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
	
	public static int getID(){
		String sql = "SELECT INTS From Variable " + "WHERE NAME = ?";
		int id = -1;
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, "WorkOrderID");
			ResultSet rs = pstmt.executeQuery();
			id = rs.getInt("INTS");
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		String sql2 = "UPDATE Variables SET INTS = ?" + "WHERE NAME =?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql2)){
			pstmt.setInt(1, (id + 1));
			pstmt.setString(2, "WorkOrderID");
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return id;
		
	}
	
	public static void setSDescription(String description, int id){
		String sql = "UPDATE WorkOrders SET SDESCRIPTION = ?" + "WHERE NUMBER = ?";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, description);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	
	public static void shiftOrders(String plate){
		String sql = "SELECT WO1,WO2,WO3,WO4 From Car " + "WHERE EMAIL = ?";
		
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, plate);
			ResultSet rs = pstmt.executeQuery();
			String[] temp = {
					rs.getString("CAR1"),
					rs.getString("CAR2"),
					rs.getString("CAR3"),
					rs.getString("CAR4"),
					rs.getString("CAR5")
					};
			
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
			
}