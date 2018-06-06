package finance;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import human.PersonHandler;

public class EventHandler {

	public enum Field {
		NAME,
		COST,
	}
	
	private int size;
	private ArrayList<String> names;
	private Hashtable<Integer,Event> events;
	private PersonHandler people;
	
	public EventHandler() {
		super();
		this.size = 0;
		this.names =  new ArrayList<String>(100);
		this.events = new Hashtable<Integer, Event>();
		this.setPeople(new PersonHandler());
	}

	public int getSize() {
		return size;
	}

	protected void setSize(int size) {
		this.size = size;
	}

	public Hashtable<Integer, Event> getEvents() {
		return events;
	}

	protected void setEvents(Hashtable<Integer, Event> events) {
		this.events = events;
	}
	
	public PersonHandler getPeople() {
		return people;
	}

	public void setPeople(PersonHandler people) {
		this.people = people;
	}

	public int addNewEvent(String name, int cost) {
		this.events.put(this.size, new Event(name, cost));
		this.names.add(name);
		this.setSize(this.size+1);
		return this.size;
	}

	public Event getEvent(int id) {
		return this.events.get(id-1);
	}
	
	public Event searchEvent(String name) {
		Event e;
		for(int i=0; i<this.size;i++) {
			e= this.events.get(i);
			if(e.getName().equals(name))return e;;
		}
		return null;
	}
	
	private Event editEvent(Event e, int size, Field[] fields, String[] texts) {
		for(int i=0; i<size; i++) {
    		Field field = fields[i];
    		String text = texts[i];
    		if(field.equals(Field.NAME)) {
    			e.setName(text);;
    		}else if(field.equals(Field.COST)){
    			e.setCost(Integer.parseInt(text));;
    		}
    	}
		return e;
	}
	
	public Event editEvent(int id, int size,Field[] fields, String[] texts ) {
		Event event= getEvent(id);
		if(event!=null) {
			return editEvent(event,size, fields, texts);
		}
		return null;
	}
	
	public Event editEvent(String name, int size,Field[] fields, String[] texts ) {
		Event event= searchEvent(name);
		if(event!=null) {
			return editEvent(event,size, fields, texts);
		}
		return null;
	}
	
	public Event deleteEvent(int id) {
		return this.events.remove(id-1);
	}
	
	public int idOfEvent(String name) {
		return this.names.indexOf(name)+1;
	}
	
	public String toString() {
		String string="";
		for(int i = 0; i<this.size; i++) {
			if(this.events.get(i)!=null)
				string += i+1 + "\t" +this.events.get(i).toString2() + "\n";
		}
		return string;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	EventHandler eventHandler = new EventHandler();
    	
    	System.out.println("##################  PayReg  ######################");
    	System.out.println();
    	System.out.println("This is EventHandler Test.");
    	System.out.println("EventHandler instantiated. Initial atributes:");
    	System.out.println("Number of Events (size of the hash table): "+ eventHandler.getSize());
    	System.out.println();
    	
    	int n= Integer.parseInt(sc.nextLine().trim());
    	for(int i=0; i<n; i++) {
    		String command = sc.nextLine().trim();
    		
    		if(command.equals("AddEvent")) {
    			
    			String line = sc.nextLine().trim();
    			Scanner s = new  Scanner(line);
    			String name = s.next().trim();
    			int cost = Integer.parseInt(s.next().trim());
    			s.close();
    			
    			int id = eventHandler.addNewEvent(name, cost);
    			System.out.println("Event was created correctly. The id is: " + id);
    			
    		}else if(command.equals("DeleteEvent")) {
    			
    			int id = Integer.parseInt(sc.nextLine().trim());
    			Event deletedEvent = eventHandler.deleteEvent(id);
    			if (deletedEvent!=null)System.out.println("Deleted event: "+deletedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("IDSearchEvent")) {
    			
    			int id = Integer.parseInt(sc.nextLine().trim());
    			Event searchedEvent = eventHandler.getEvent(id);
    			if (searchedEvent!=null)System.out.println("Event was found: "+searchedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("NameSearchEvent")) {
    			
    			String name = sc.nextLine().trim();
    			Event searchedEvent = eventHandler.searchEvent(name);
    			if (searchedEvent!=null)System.out.println("Event was found: "+searchedEvent.toString());
    			else System.out.println(name +" does not exist." );
    			
    		}else if(command.equals("IDEditEvent")) {
    			
    			String line = sc.nextLine().trim();
    			Scanner s = new  Scanner(line);
    			int id = Integer.parseInt(s.next().trim());
    			int changes = Integer.parseInt(s.next().trim());
    			Field[] fields = new Field[changes];
    			String[] texts = new String[changes];
    			for(int k=0; k<changes;k++) {
    				String fld = s.next().trim();
    				Field field;
    				if(fld.equals("COST"))field = Field.COST;
    				else field = Field.NAME;
    				fields[k]=field;
    				
    				String text = s.next().trim();
    				texts[k]=text;
    			}
    			s.close();
    			Event editedEvent = eventHandler.editEvent(id, changes, fields, texts);
    			if (editedEvent!=null)System.out.println("Event was edited: "+editedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("NameEditEvent")) {
    			
    			String line = sc.nextLine().trim();
    			Scanner s = new  Scanner(line);
    			String name = s.next().trim();
    			int changes = Integer.parseInt(s.next().trim());
    			Field[] fields = new Field[changes];
    			String[] texts = new String[changes];
    			for(int k=0; k<changes;k++) {
    				String fld = s.next().trim();
    				Field field;
    				if(fld.equals("COST"))field = Field.COST;
    				else field = Field.NAME;
    				fields[k]=field;
    				
    				String text = s.next().trim();
    				texts[k]=text;
    			}
    			s.close();
    			Event editedEvent = eventHandler.editEvent(name, changes, fields, texts);
    			if (editedEvent!=null)System.out.println("Event was edited: "+editedEvent.toString());
    			else System.out.println(name +" does not exist." );
    		}else {
    			System.out.println("Wrong command");
    			if (sc.hasNextLine())sc.nextLine();
    		}
    	}
    	sc.close();
    	System.out.println("Number of Events (size of the hash table): "+ eventHandler.getSize());
    	System.out.println("Test ended.");
	}

	/*
	 * Trivial example to test the Class:
	 * 
8
Add
Cena 2359600
SearchId
1
SearchName
Cena
EditId
1 2 NAME Cena2017 COST 2500000
EditName
Cena2017 1 COST 5000000
Delete
1
Delete
1
cOmandrare

	 */
}
