import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkOrder {
	
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
			
}