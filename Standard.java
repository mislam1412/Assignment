
public class Standard extends Ticket{ // inherits from ticket
	
	Standard() {
		// setting inherited variables
		price = 8;				
		name = "Standard";
	}
	
	//overriding method
	protected void buy(){
		totalPrice = totalPrice + 8;
	}
}
