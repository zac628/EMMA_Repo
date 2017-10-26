import java.util.*;

public class Client{
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private Car[] cars = new Car[10];
	private WorkOrder[] workOrders = new WorkOrder[10];

	public Client(String name, String number, String email, String address){
		this.name = name;
		this.phoneNumber = number;
		this.email = email;
		this.address = address;
	}

	public void setName(String newName){
		this.name = newName;
	}

	public String getName(){
		return this.name;
	}

	public void setNumber(String number){
		this.phoneNumber = number;
}
	
	public String getNumber(){
		return this.phoneNumber;
}

public void setEmail(String email){
	this.email = email;
}

public String getEmail(){
	return this.email;
}

public void setAddress(String address){
	this.address = address;
}
public String getAddress(){
	return this.address;
}

public void addCar(){
	int year;
	Scanner scan = new Scanner(System.in);
	System.out.print("Type: ");
	String type = new String(scan.nextLine());
	System.out.print("Make: ");
	String make = new String(scan.nextLine());
	System.out.print("Model: ");
	String model = new String(scan.nextLine());
	System.out.print("Year: ");
	year = scan.nextInt();
	System.out.print("\nLicense Plate Number: ");
	String license = new String(scan.nextLine());
	
	Car car = new Car(type, make, model, year, license);
	
	int index = -1;
	for(int i = 0; i < 10; i++){
		if(this.cars[i] == null){
			index = i;
			break;
		}
	}

	if(index == -1)
		System.out.println("Error: Client has too many cars.");
	else
		this.cars[index] = car;
}

public void removeCar(Car car){
	for(int i = 0; i < 10; i++){
		if(cars[i].getLicense().equals(car.getLicense()))
			cars[i] = null;
	}
}

public void addWorkOrder(Car car){
	int carIndex = -1;
	for(int i =0; i < 10; i++){
		if(cars[i].getLicense().equals(car.getLicense()))
			carIndex = i;
	}
	if(carIndex == -1)
		System.out.println("Error: Car not found.");
	else{
		int index = -1;
		for(int i = 0; i < 10; i++){
			if(workOrders[i] == null){
				index = i;
				break;
			}
		}
	
		if(index == -1)
		System.out.println("Error: Client has too many work orders.");
		else{
			WorkOrder wo = new WorkOrder(this, car);
			workOrders[index] = wo;
		}	
	}	
}

public void removeWorkOrder(WorkOrder wo, Mechanic m){
	wo.removeWorkOrder(m);
}

public Car getCar(String license){
	for(int i = 0; i < 10; i++){
		if(cars[i].getLicense().equals(license))
			return cars[i];
	}
	System.out.println("Error: Car not found.");
	return null;
}

public WorkOrder getWorkOrder(int number){
	for(int i = 0; i < 10; i++){
		if(workOrders[i].getOrderNumber() == number)
			return workOrders[i];
	}
	System.out.println("Error: Work order not found.");
	return null;
}
}
