

public class Mechanic extends Employee {
	
	private WorkOrder[] orders = new WorkOrder[10];
	private String specialty;
	
	public Mechanic(String specialty){
		new Employee();
		this.specialty = specialty;
		this.designation = "Mechanic";
	}
	
	public void addOrder(int t){
		//Search DB for work order with order # t
		//Go through orders[] and put work order in first opening
	}
	
	public void removeOrder(int t){
		for(int i = 0; i < 10; i++){
			if(orders[i].getOrderNumber() == t)
				orders[i] = null;
			
		}
	}
	
	public String getSpecialty(){
		return specialty;
	}

}
