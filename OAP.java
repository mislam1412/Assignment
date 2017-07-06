
public class OAP extends Ticket{ // inherits from ticket
	
	OAP(){
		// setting inherited variables
		price = 6;
		name = "OAP";
	}
	
	//overriding method
	protected void buy(){
		totalPrice = totalPrice + 6;
	}
}
