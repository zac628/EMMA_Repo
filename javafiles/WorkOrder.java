public class WorkOrder {

private Car car;
private Client client;
private String orderDescription;
private int orderNumber;
private static int count = 0;

	public WorkOrder(Client cl, Car c){
		client = cl;
		car = c;
		orderNumber = ++count;
	}
	public WorkOrder(Client cl, Car c, String o){
		car = c;
		client = cl;
		orderDescription = o;
		orderNumber = ++count;
	}
	public String getOrderDescription(){
		return orderDescription;
	}
	public Car getCar(){
		return car;
	}
	public Client getClient(){
		return client;
	}
	public void setOrderDescription(String s){
		orderDescription = s;
	}
	
	public int getOrderNumber(){
		return orderNumber;
	}
	public void assignWorkOrder(Mechanic m){
		//Remove this workorder from the list of workorders in the database after assigning it to a mechanic
		m.addOrder(orderNumber);
	}
	public void removeWorkOrder(Mechanic m){
		m.removeOrder(orderNumber);
	}
}