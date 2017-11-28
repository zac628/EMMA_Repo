import java.sql.*;

public class Reports {
	
	private static double laborCost;
	private static double revenue;
	private static double inventoryCost;
	
	public static double getRevenue(){
		//Add all money paid to shop
		return 0.0;
	}
	
	public static double getLaborCost(){
		laborCost = 0;
		
		String sql = "SELECT HOURS,RATE From User";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
				Statement stmt = conn.createStatement();){
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				laborCost += rs.getDouble("HOURS") * rs.getDouble("RATE");
			}
			
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return laborCost;
	}
}
