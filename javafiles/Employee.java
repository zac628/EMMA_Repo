import java.util.*;
public class Employee {
	private static int employeeCount = 0;
	private int idNumber;
	private String password;
	private String fName;
	private String lName;
	private double hours;
	Scanner scan = new Scanner(System.in);
	 
	public Employee(){
		String temp1, temp2;
		int confirm = 1;
		System.out.print("First Name: ");
		this.fName = scan.nextLine();
		System.out.print("Last Name: ");
		this.lName = scan.nextLine();
		System.out.print("Create Password: ");
		temp1 = scan.nextLine();
		System.out.print("Confirm Password: ");
		temp2 = scan.nextLine();
		if(temp1.equals(temp2))
			confirm = 0;
		while(confirm == 1){
			System.out.println("Passwords do not match. Try Again.");
			System.out.print("Create Password: ");
			temp1 = scan.nextLine();
			System.out.print("Confirm Password: ");
			temp2 = scan.nextLine();
			if(temp1.equals(temp2))
				confirm = 0;
		}
		employeeCount++;
		this.idNumber = employeeCount;
	}

}
