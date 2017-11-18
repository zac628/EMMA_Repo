import javax.swing.JFrame;
import java.util.*;
public class Main {

	/**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    
    public static void main(String args[]){
    	//Tests Login credentials against database successfully!
    	Scanner scan = new Scanner(System.in);
    	
    	ContactForm.go();
    	
    	//new SQL table named User in the database with fields Username and Password of type text
    	DBTools.createNewTable("CREATE TABLE IF NOT EXISTS User (\n"
        		+ " Username text NOT NULL,\n"
                + "	Password text NOT NULL\n"
                + ");");
    	DBTools.insert("abc", "abc");
    	
    	System.out.println("Login credentials currently in database: \nUsername\tPassword\n");
    	System.out.println("admin\t\tpass\n!@#$%^&*()\t?.,\nzac@gmail.com\tRi$eabovE\nzazc\t\t$\n1\t\t2\nabc\t\tabc\n");
    	System.out.println("ENTER to launch LoginWindow: ");
    	scan.nextLine();
    	Login.go();
    	//Login_VC();
    	
   
    }
}
