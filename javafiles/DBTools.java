import java.sql.*;

public class DBTools {
	
	 static String url = "jdbc:sqlite:../../GitHub/EMMA_Repo/test.db";
	 
	 public static void connect() {
	        Connection conn = null;
	        try {
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	    }
	 
	    public static void createNewTable(String sql) {
	    	/*FORMAT FOR CREATING TABLES
	    	 * 
	    	 * "String sql = CREATE TABLE IF NOT EXISTS User (\n"
	        		+ " Username text NOT NULL,\n"
	                + "	Password text NOT NULL\n"
	                + " Designation TEXT\n"
	                + ");"
	    	*/
	    	
	    	 // SQLite connection string
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	        	System.out.println("\nConnection to SQLite has been established.\n");
	            // create a new table
	            stmt.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    public static void insert(String u, String p, String d, String f, String l, double r) {
	        String sql = "INSERT INTO User(USERNAME,PASSWORD,DESIGNATION,FNAME,LNAME,RATE) VALUES(?,?,?,?,?,?)";
	        if(!testAll(u,p)){
		        try (Connection conn = DriverManager.getConnection(url);
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setString(1, u);
		            pstmt.setString(2, p);
		            pstmt.setString(3, d);
		            pstmt.setString(4, f);
		            pstmt.setString(5, l);
		            pstmt.setDouble(6, r);
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
	        }
	    }
	    
	    public static boolean testAll(String one, String two){
	        String sql = "SELECT Username, Password FROM User";
	        
	        try (Connection conn = DriverManager.getConnection(url);
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                if(rs.getString("Username").equals(one) && rs.getString("Password").equals(two)){
	                	return true;
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			return false;
	    }
}
