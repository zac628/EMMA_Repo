import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {

	/**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {
 
       String url = "jdbc:sqlite:" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String args[]){
    	createNewDatabase("test.db");
    	Login_VC();
    }
    public static void Login_VC()
	{
	JFrame frame = new JFrame("EMMA");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	LoginWindow panel = new LoginWindow();
	frame.getContentPane().add(panel);
	frame.pack();
	frame.setVisible(true);
	}	
}
