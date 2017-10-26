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
    	
    	Car testcar = new Car("type","make","model",2016,"ABC 123");
    	System.out.println("Successfully made and intialized Car Object: 'testcar'");
    	System.out.print("Type:"+testcar.getClassification()+" Make:"+testcar.getMake()+" Model:"+testcar.getModel()+" Year:"+testcar.getYear()+" LicensePlate:"+testcar.getLicense()+"\n");
    	System.out.println("ENTER to continue to WorkOrder testing: ");
    	scan.nextLine();
    	
    	Client justin = new Client("Justin","2727272727", "j@yahoo.com", "1 Field St");
        Car mine = new Car("Sedan", "Honda", "Civic", 2015, "CGZ3731");
        WorkOrder example = new WorkOrder(justin, mine, "Car Broke");
       
        System.out.println("Client name: " + example.getClient().getName());
        System.out.println("License plate #: " + example.getCar().getLicense());
        System.out.println("Order Description: " +example.getOrderDescription());
        System.out.println("Order Number: " + example.getOrderNumber());
       
        example.setOrderDescription("Splash Guard is falling off.");
       
        System.out.println("New order description: " + example.getOrderDescription());
        System.out.println("\nENTER to continue to Login and DB testing:");
        scan.nextLine();
    	
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
    	Login_VC();
    	
    	SuckMe.ass();
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
