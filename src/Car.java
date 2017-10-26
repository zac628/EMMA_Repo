/* An instance of a car will be used to document and describe a vehicle to be stored in the *database and system. These will be used in conjunction with the WorkOrder class to *submit work orders/repair requests.
*/ 

public class Car {

	/* classification will have a drop down selection menu full of sedan, coupe, truck, SUV, 
	* etc...
	*/
	private String classification;

/* make will have a drop down selection menu full of Honda, Toyota, Ford, Subaru, 
	* etc...
	*/
	private String make;

/* model will have a drop down selection menu full of Camry, Corolla, Focus, Civic, 
	* etc...
	*/
	private String model;

	// Year will hold int value representing the year of the car
	private int year;
	
	// License will hold String value representing the license plate number
	private String license;
	
	//Constructor to set values for car instance. All values are required
	public Car(String type, String make, String model, int year, String license) {
		classification = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.license = license;
	}
	
	public String getClassification() {
		return classification;
	}
	
	
	
	public void setClassification(String newClass){
		classification = newClass;
	}
	
	public String getMake(){
		return make;
	}
	
	
	public void setMake(String newMake){
		make = newMake;
	}
	
	
	public String getModel(){
		return model;
	}
	
	public void setModel(String newModel){
		model = newModel;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int newYear){
		year = newYear;
	}
	
	public String getLicense(){
		return license;
	}
	
	public void setLicense(String newLicense){
		license = newLicense;
	}
}

