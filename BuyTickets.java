import java.util.Scanner;


public class BuyTickets {
	
	public static void main(String args[]) {
		
		boolean invalidEntry = true; // boolean variable to keep check of wrong entry on no. of people in a group
		int groupSize = 0; 			//no. of people in a group, i.e. tickets per order
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the number of ticket(s) you would like to purchase:");
		
		while(invalidEntry) { //checking for valid entry of group members
			
		groupSize = scan.nextInt();
		
		if(groupSize > 5 || (groupSize <= 0))
			System.out.println("Sorry you're group is too large! Please ensure value is between 1 and 5 and enter again:");
		else {
			if(groupSize > 1)
				System.out.println("You have booked tickets for: " + groupSize + " people" );
			else
				System.out.println("You are going to book a ticket for " + groupSize + " person!" );
			
			invalidEntry = false;  // no longer an invalid entry. Close loop
			}
		}
		
		System.out.println("==========");
		
		Movies list = new Movies();  //making an object of Movies to use DisplayMovies() method
 		
		list.DisplayMovies();   //display list of all movies that are playing 
		
		System.out.println("==========");
		
		System.out.println("Please enter the ID number of the movie (1 - 4) you wish to watch:");
		
		invalidEntry = true; //reusing boolean variable to check for error in movie number entry
		
		while(invalidEntry) { // checking for valid entry of movie ID
			int movieID = scan.nextInt();
			
			if(movieID > 4 || movieID <= 0)
				System.out.println("Invalid movie ID! Please enter the movie ID (1-4):");
			
			else {
				System.out.println("You have booked tickets for " + list.getMoviesList()[movieID-1]); // since our array of movies names starts from zero and the movies are displayed from 1-4, so we will have to subtract 1 in order to correctly display the movie name
				invalidEntry = false;  // no longer an invalid entry. Close loop
				
				}
		}
		
		System.out.println("==========");
		
		System.out.println("Now please enter the day which you want to book the ticket(s) for:");
		
		String day = ""; // initializing day variable outside of loop because it has to be used afterwards
		
		invalidEntry = true; //reusing boolean variable to check for error in day entry
		
		while(invalidEntry) { // checking for valid entry of day
			
			day =  scan.next();
	
			day = day.toLowerCase(); // convert entry to lower case, this way we don't have to use multiple cases for upper and lower case
			
			if( (day.equals("monday")) || (day.equals("tuesday")) || (day.equals("wednesday")) || (day.equals("thursday")) || (day.equals("friday")) || (day.equals("saturday") ) || (day.equals("sunday") ) )
				invalidEntry = false;  		//valid day, break loop
				
			else 
				System.out.println("You've entered an invalid day, please try again:");
		
		}
		
		Ticket newTicket = new Standard(); // We cannot make an object from TicketClass of type Ticket, because it is an abstract class. Hence we use any other subclass. This won't matter since we only need to use displayTypes() method.
		
		System.out.println("==========");
		
		System.out.println("The following types of tickets are available for purchase: ");
		
		newTicket.displayTypes(); // calling display function to display list of all ticket types. 
		
		System.out.println("==========");
		
		int totalOrderPrice = 0; // initialize variable to store the total cost of the order
		
		
		for(int i = 0 ; i < groupSize ; i++) {
			
			
			Ticket[] totalOrderTickets = new Ticket[groupSize]; // Using polymorphic array to store each ticket in.
			
			System.out.println("Select the type of ticket (1 - 4) for ticket no. " + (i+1) + ":"); //add 1 in loop counter (i) to display ticket number from 1
			
			invalidEntry = true; //reusing boolean variable to check for error in ticket ID entry
			
			int ticketID = 0; 
			
			while(invalidEntry) { // checking for valid entry of movie ID
				
				ticketID = scan.nextInt();
				
				if(ticketID > 4 || ticketID <= 0)
					System.out.println("Invalid ticket ID! Please try again, entering ID between 1-4:");
				
				else 
					invalidEntry = false;  // no longer an invalid entry. Close loop
			}
			
			String typeSelected = newTicket.getTicketArray()[ticketID-1].name; // getting name of selected ticket from Tickets Array. Again, as our ticketArray starts from zero but out display list started from 1, we will have to subtract 1 from ticketArray position to get correct type
			
			System.out.println("You have selected " + typeSelected + " type for ticket No. " + (i+1));
			System.out.println("------");
			
			if(typeSelected.equals("Standard")) {
				totalOrderTickets[i] = new Standard();			  		// make new Standard ticket type object
				totalOrderTickets[i].buy();						 		// call the buy method to record the purchase
				totalOrderPrice += totalOrderTickets[i].price; 			// get price from order and add to the total price
			}
			
			else if(typeSelected.equals("OAP")) {						
				totalOrderTickets[i] = new OAP();						
				totalOrderTickets[i].buy();								
				totalOrderPrice += totalOrderTickets[i].price;
			}
			
			else if(typeSelected.equals("Student")) {
				totalOrderTickets[i] = new Student();			
				totalOrderTickets[i].buy();
				totalOrderPrice += totalOrderTickets[i].price;
			}
			
			else{  	
				totalOrderTickets[i] = new Child();			
				totalOrderTickets[i].buy();
				totalOrderPrice += totalOrderTickets[i].price;
			}
			
		}
		
		if(day.equals("wednesday")) {  													// applying Wednesday discount
			System.out.println("Wednesday discount will be applied on order!");
			int wednesdayDiscount = 2 * groupSize;										// on each order, a 2 pound discount is valid, so total discount would be 2 * number of orders, i.e. groupSize
			totalOrderPrice = totalOrderPrice - wednesdayDiscount;						// deduct discount from total price
		}
		
		System.out.println("The total cost of your ticket(s) for this movie is: £" + totalOrderPrice);
		
	}
}
