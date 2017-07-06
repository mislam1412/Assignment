
public abstract class Ticket {
	
	protected int totalPrice; 		// total price of all types of tickets
	protected int price;	  		// specific ticket price
	protected String name; 	 		// type of ticket
	private Ticket[] ticketArray;  	// polymorphic array to store different types of tickets
	
	Ticket[] getTicketArray(){
		return ticketArray;
	}
	
	void setTicketArray(Ticket[] t1){
		 ticketArray = t1;
	}

	
	protected abstract void buy();  // abstract method buy. It needs to be over ridden by each subclass.
	
	void displayTypes() { 
		
		// using polymorphism to make objects of subclasses of ticket
		
		Ticket standardticket = new Standard();
		Ticket oapTicket = new OAP();
		Ticket studentTicket = new Student();
		Ticket childTicket = new Child();
		
		Ticket[] ticketArray = {standardticket,oapTicket,studentTicket,childTicket};  // add each object to the ticketArray
		setTicketArray(ticketArray); 		// set the ticketArray, so it can be used outside the class
				
		for(int i=0; i < ticketArray.length ; i++)
			System.out.println( (i+1) + ". " + ticketArray[i].name + " - £" + ticketArray[i].price);
	
	}
	
}
