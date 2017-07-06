
public class Child extends Ticket { // inherits from ticket
	
	Child(){
		// setting inherited variables
		price = 4;
		name = "Child";
	}
	
	//overriding method
	protected void buy(){
		totalPrice = totalPrice + 4;
	}
}
