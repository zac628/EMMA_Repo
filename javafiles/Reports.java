import java.sql.*;

public class Reports {
	
	private static double laborCost;
	private static double revenue;
	private static double inventoryCost;
	
	public static double getRevenue(){
		revenue = 0.0;
		//Add all money paid to shop
		return revenue;
	}
	
	public static double getLaborCost(){
		laborCost = 0.0;
		
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
	
	
	public static double getInventoryCost(){
		inventoryCost = 0;
		//Add total cost of parts bought
		return inventoryCost;
	}
	
	public static double getProfit(){
		getRevenue();
		getLaborCost();
		getInventoryCost();
		
		return revenue - (laborCost + inventoryCost);
	}
}
