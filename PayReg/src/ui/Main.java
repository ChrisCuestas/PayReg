package ui;

import java.util.Date;
import java.util.Scanner;

import finance.*;
import human.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	EventHandler eventHandler = new EventHandler();
    	PersonHandler personHandler = new PersonHandler();
    	
    	System.out.println("##################  PayReg  ######################");
    	System.out.println();
    	System.out.println("This is a Test.");
    	System.out.println("Number of Events: "+ eventHandler.getSize());
    	System.out.println();
    	
    	System.out.println("Welcome to the PayReg system.");
    	
    	boolean isActive = true;
    	while(isActive) {
    		System.out.println("\n\n"+"Here below you have several options to perform:");
        	System.out.println("ACTION:\t\t\t\t COMMAND");
        	System.out.println("To add a new event: \t\t AddEvent");
        	System.out.println("To delete an event: \t\t DeleteEvent");
        	System.out.println("To get the ID of an event: \t IDofEvent");
        	System.out.println("To get the info of an event: \t SearchEvent");
        	System.out.println("To manage an event: \t\t ManageEvent");
        	System.out.println("To make the list of events: \t EventsList");
        	System.out.println("To finish: \t\t\t Close");
    		System.out.println("\n\n"+"Write a command: ");
    		String command = sc.nextLine().trim();
    		
    		if(command.equals("AddEvent")) {
    			
    			System.out.println("\t Insert the name of the event: ");
    			String name = sc.nextLine().trim();
    			System.out.print("\t Insert the total cost of the event: $");
    			int cost = Integer.parseInt(sc.nextLine().trim());
    			
    			int id = eventHandler.addNewEvent(name, cost);
    			System.out.println("\t Event was created correctly. The id is: " + id);
    			System.out.println(eventHandler.getEvent(id).toString());
    			
    		}else if(command.equals("DeleteEvent")) {
    			
    			System.out.println("\t Insert the Id of the event to delete: ");
    			int id = Integer.parseInt(sc.nextLine().trim());
    			Event deletedEvent = eventHandler.deleteEvent(id);
    			if (deletedEvent!=null)System.out.println("Deleted event: \n"+deletedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("IDofEvent")) {
    			
    			System.out.println("\t Insert the name of the event: ");
    			String name = sc.nextLine().trim();
    			int id = eventHandler.idOfEvent(name);
    			if (id==-1)System.out.println(name +" does not exist." );
    			else System.out.println("Event was found. Its ID is: "+id);
    			
    		}else if(command.equals("SearchEvent")) {

    			System.out.println("\t Insert the name of the event: ");
    			String name = sc.nextLine().trim();
    			Event searchedEvent = eventHandler.searchEvent(name);
    			if (searchedEvent!=null)System.out.println("Event was found: "+searchedEvent.toString());
    			else System.out.println(name +" does not exist." );
    			
    		}else if(command.equals("ManageEvent")) {
    			
    			System.out.println("\t Insert the Id of the event: ");
    			int eventId = Integer.parseInt(sc.nextLine().trim());
    			Event event = eventHandler.getEvent(eventId);
    			
    			boolean isActiveEvent = true;
    	    	while(isActiveEvent) {
    	    		System.out.println("\n\n"+"Here below you have several options to perform:");
    	        	System.out.println("ACTION:\t\t\t\t COMMAND");
    	        	System.out.println("To edit properties of event: \t EditEvent");
    	        	System.out.println("To make a new payment: \t\t NewPayment");
    	        	System.out.println("To make an aditional payment: \t AdditionalPayment");
    	        	System.out.println("To make the list of payments: \t PaymentsList");
    	        	/*System.out.println("To manage an event: \t\t ManageEvent");*/
    	        	System.out.println("To return to Main Menu: \t\t Return");
    	    		System.out.println("\n\n"+"Write a command: ");
    	    		String eventCommand = sc.nextLine().trim();
    	    		
    	    		if(eventCommand.equals("EditEvent")) {
        	        	System.out.println("ACTION:\t\t\t\t COMMAND");
        	        	System.out.println("To activate the event: \t\t Enable");
        	        	System.out.println("To disable the event: \t\t Disable");
        	        	System.out.println("To set a new total cost: \t NewCost");
        	        	System.out.println("To +/- to the total cost: \t AddToCost");
        	        	System.out.println("To return into Main Menu: \t\t Return");
        	    		System.out.println("\n\n"+"Write a command: ");
        	    		String action = sc.nextLine().trim();
        	    		
        	    		if(action.equals("Enable")) {
        	    			event.isActive(true);
        	    		}else if(action.equals("Disable")) {
        	    			event.isActive(false);
        	    		}else if(event.isActive()) {
        	    			if(action.equals("AddToCost")) {
        	        			System.out.print("Insert the additional amount: $");
        	    				int addAmount = Integer.parseInt(sc.nextLine().trim());
            	    			event.addToCost(addAmount);
            	    		}else if(action.equals("NewCost")) {
            	    			System.out.print("Insert the new cost of the event: $");
            	    			int cost = Integer.parseInt(sc.nextLine().trim());
            	    			event.setCost(cost);
            	    		}
        	    		}else if(action.equals("Return")) 
        	    			isActiveEvent = false;
        	    		else {
        	    			System.out.println("Wrong command");
        	    			if (sc.hasNextLine())sc.nextLine();
        	    		}
    	    		}else if(eventCommand.equals("NewPayment")) {
    	    			System.out.print("Insert the Name of the person (firstName lastName1 lastName2): ");
    	    			String personName = sc.nextLine().trim();
    	    			Scanner s = new Scanner(personName);
    	    			s.useDelimiter(" ");
    	    			String firstName = s.next().trim();
    	    			String lastName1 = s.next().trim();
    	    			String lastName2 = s.next().trim();
    	    			String id = personHandler.buildId(firstName, lastName1, lastName2);
    	    			s.close();
    	    			String ans ="no";
    	    			String ans2="no";
    	    			if(personHandler.searchPerson(id)!=null) {
    	    				Date date = new Date();
	    	    			System.out.print("\n"+"Insert the amount of the payment: $");
	    	    			int amount = Integer.parseInt(sc.nextLine().trim());
	    	    			event.addNewPayment(id, date, amount);
    	    			}else {
    	    				while(personHandler.searchPerson(id)==null) {
        	    				System.out.println("The Name of the person does not exist, do you want to create a new Person? ");
        	    				ans = sc.nextLine().trim().toLowerCase();
        	    				if(ans.equals("yes")) {
        	    					System.out.println("Insert the phone of the person: ");
        	    					long phone = Long.parseLong(sc.nextLine().trim());
        	    					System.out.println("Insert the E-Mail of the person: ");
        	    					String eMail = sc.nextLine().trim();
        	    					System.out.println("Choose the way of notification: SMS, WHATSAPP, EMAIL");
        	    					String notifWay = sc.nextLine().trim();
        	    					personHandler.addNewPerson(firstName, lastName1, lastName2, phone, eMail, notifWay);
        	    					Date date = new Date();
        	    	    			System.out.print("\n"+"Insert the amount of the payment: $");
        	    	    			int amount = Integer.parseInt(sc.nextLine().trim());
        	    	    			event.addNewPayment(id, date, amount);
        	    				}else {
        	    					System.out.println("Do you want to rewrite the name? ");
            	    				ans2 = sc.nextLine().trim().toLowerCase();
            	    				if(ans2.equals("yes")) {
            	    					System.out.print("Insert the Name of the person (firstName lastName1 lastName2): ");
            	    	    			personName = sc.nextLine().trim();
            	    	    			Scanner c = new Scanner(personName);
            	    	    			c.useDelimiter(" ");
            	    	    			firstName = c.next().trim();
            	    	    			lastName1 = c.next().trim();
            	    	    			lastName2 = c.next().trim();
            	    	    			id = personHandler.buildId(firstName, lastName1, lastName2);
            	    	    			c.close();
            	    	    			Date date = new Date();
            	    	    			System.out.print("\n"+"Insert the amount of the payment: $");
            	    	    			int amount = Integer.parseInt(sc.nextLine().trim());
            	    	    			event.addNewPayment(id, date, amount);
            	    				} else break;
        	    				}
        	    			}
    	    			}
    	    		}else if(eventCommand.equals("AdditionalPayment")) {
    	    			System.out.print("\n Insert the description of the payment: ");
    	    			String name = sc.nextLine().trim();
    	    			Date date = new Date();
    	    			System.out.print("\n"+"Insert the amount of the payment: $");
    	    			int amount = Integer.parseInt(sc.nextLine().trim());
    	    			event.addNewAditionalPayment(name, date, amount);
    	    		}else if(eventCommand.equals("PaymentsList")) {
    	    			System.out.print(event.makeList(personHandler));
    	    		}else if(eventCommand.equals("Return")) 
    	    			isActiveEvent = false;
    	    		else {
    	    			System.out.println("Wrong command");
    	    			if (sc.hasNextLine())sc.nextLine();
    	    		}
    	    	}
    			
    			//if (editedEvent!=null)System.out.println("Event was edited: "+editedEvent.toString());
    			//else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("EventsList")) {
    			System.out.println(eventHandler.toString());
    		}else if(command.equals("Close")) 
    			isActive = false;
    		else {
    			System.out.println("Wrong command");
    			if (sc.hasNextLine())sc.nextLine();
    		}
    	}
    	sc.close();
    	System.out.println("Number of Events: "+ eventHandler.getSize());
    	System.out.println("Test ended.");
	}
}
