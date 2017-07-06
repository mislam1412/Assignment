
public class Student extends Ticket { // inherits from ticket
	
	Student(){
		// setting inherited variables
		price = 6;
		name = "Student";
	}
	
	//overriding method
	protected void buy(){
		totalPrice = totalPrice + 6;
	}
}
