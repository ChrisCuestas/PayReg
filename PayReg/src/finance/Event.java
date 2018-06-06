package finance;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;

import human.PersonHandler;

public class Event {

	
	private String name;
	private int numPeople;
	private int cost;
	private int totalCollected;
	private boolean isActive;
	private Hashtable<String, TreeMap<Date,Payment>> data;
	private int totalAditionalPayments;
	private ArrayList<Payment> aditionalPayments;
	
	
	public Event(String name, int cost) {
		super();
		this.isActive=true;
		this.name = name;
		this.numPeople = 0;
		this.cost = cost;
		this.totalCollected = 0;
		this.data = new Hashtable<String, TreeMap<Date,Payment>> ();
		this.totalAditionalPayments = 0;
		this.aditionalPayments = new ArrayList<Payment>();
	}
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	public int getNumPeople() {
		return numPeople;
	}

	protected void setNumPeople(int load) {
		this.numPeople = load;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotalCollected() {
		return totalCollected;
	}

	protected void setTotalCollected(int totalCollected) {
		this.totalCollected = totalCollected;
	}

	public boolean isActive() {
		return isActive;
	}

	public void isActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Hashtable<String, TreeMap<Date, Payment>> getData() {
		return data;
	}

	protected void setData(Hashtable<String, TreeMap<Date, Payment>> data) {
		this.data = data;
	}
	
	public ArrayList<Payment> getAditionalPayments() {
		return this.aditionalPayments;
	}

	protected void setAditionalPayments(ArrayList<Payment> newAdPayments) {
		this.aditionalPayments = newAdPayments;
	}
	
	public int getTotalAditionalPayments() {
		return this.totalAditionalPayments;
	}
	
	public void setTotalAditionalPayments(int adtionalPayments) {
		this.totalAditionalPayments = adtionalPayments;
	}
	
	public int getCostByPerson() {
		if(this.numPeople==0)return -1;
		return (this.cost-this.totalAditionalPayments)/this.numPeople;
	}
	
	public void addToCost(int addAmount) {
		this.setCost(this.cost+addAmount);
	}
	
	public int getRemains() {
		return this.getCost()-this.getTotalCollected();
	}
	
	public TreeMap<Date,Payment> searchPersonPaymentList(String personId) {
		return this.data.get(personId);
	}
	
	public void addNewPayment(String personId, Date date, int amount) {
		TreeMap<Date, Payment> paymentList = this.data.get(personId);
		Payment payment = new Payment(date, amount, personId);
		if (paymentList!=null){
			paymentList.put(date, payment);
		} else {
			paymentList = new TreeMap<Date, Payment>();
			paymentList.put(date, payment);
			this.data.put(personId, paymentList);
			this.setNumPeople(this.numPeople+1);
		}
		this.totalCollected+=amount;
	}
	
	public void addNewAditionalPayment(String name, Date date, int amount) {
		Payment payment = new Payment(date, amount, name);
		this.aditionalPayments.add(payment);
		this.totalAditionalPayments+=amount;
		this.totalCollected+=amount;
	}
	
	public Payment searchPayment(String personId, Date date) {
		Payment payment = this.data.get(personId).get(date);
		if(payment == null) return null;
		else return payment;
	}
	
	public Payment searchAditionalPayment(String name) {
		for(Payment p: aditionalPayments) 
			if(p.getPersonId().equals(name)) 
				return p;
		return null;
	}
	
	public Payment searchAditionalPayment(Date date) {
		for(Payment p: aditionalPayments) 
			if(p.getDate().equals(date)) 
				return p;
		return null;
	}
	
	protected Payment deletePayment(String personId, Date date) {
		Payment deletedPayment = this.data.get(personId).remove(date);
		this.totalCollected-=deletedPayment.getAmount();
		return deletedPayment;
	}
	
	protected Payment deleteAditionalPayment(String name) {
		Payment deletedPayment = null;
		for(int i=0; i<this.aditionalPayments.size();i++) {
			if(this.aditionalPayments.get(i).getPersonId().equals(name)) {
				deletedPayment = this.aditionalPayments.remove(i);
				this.totalAditionalPayments+=deletedPayment.getAmount();
				this.totalCollected-=deletedPayment.getAmount();
				break;
			}
		}
		return deletedPayment;
	}
	
	public String makeList(PersonHandler pHandler) {
		String list = "";
		String [] ids = new String[pHandler.getIds().size()];
		ids = pHandler.getIds().toArray(ids);
		for(int i=0; i<ids.length;i++) {
			list += ids[i] + this.data.get(ids[i]).toString() + "\n";
		}
		return list;
	}
	
	@Override
	public String toString() {
		return "Name:" + name + "\n"
				+"Is active? " + this.yesNo(isActive) + "\n"
				+ "There are " + numPeople + " people \n"
				+ "The total cost is: $" + cost+ "\n" 
				+ "Payment for each person: $" + this.getCostByPerson() + "\n"
				+ "Total amount collected: $" + totalCollected + "\n"
				+ "Total left: $"+ this.getRemains()+ "\n"
				+ "Aditional money collected: $"+this.totalAditionalPayments;
	}
	
	public String toString2() {
		return "Name:" + name + "\t"
				+"Is active: " + this.yesNo(isActive) + "\t"
				+ "There are " + numPeople + " people \t"
				+ "The total cost is: $" + cost+ "\t" 
				+ "Payment for each person: $" + this.getCostByPerson() + "\t"
				+ "Total amount collected: $" + totalCollected + "\t"
				+ "Total left: $"+ this.getRemains()+ "\t"
				+ "Aditional money collected: $"+this.totalAditionalPayments;
	}
	
	private String yesNo(boolean isActive) {
		if(isActive) return "yes";
		else return "no";
	}
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	
    	System.out.println("##################  PayReg  ######################");
    	System.out.println();
    	System.out.println("This is Event Test.");
    	
    	System.out.print("Name of the new event: ");
    	String name = sc.nextLine().trim();
    	
    	System.out.println();
    	System.out.print("Cost of the new event: $");
    	int cost = Integer.parseInt(sc.nextLine().trim());
    	System.out.println();
    	
    	Event event = new Event(name, cost);
    	
    	System.out.println("Event instantiated. Initial atributes:");
    	System.out.println(event.toString());
    	System.out.print("Cantidad de comandos: ");
    	
    	int n= Integer.parseInt(sc.nextLine().trim());
    	System.out.println();
    	/*for(int i=0; i<n; i++) {
    		String command = sc.nextLine().trim();
    		
    		if(command.equals("AddPayment")) {
    			
    			String line = sc.nextLine().trim();
    			Scanner s = new  Scanner(line);
    			String name = s.next().trim();
    			int cost = Integer.parseInt(s.next().trim());
    			s.close();
    			
    			int id = event.addNewEvent(name, cost);
    			System.out.println("Event was created correctly. The id is: " + id);
    			
    		}else if(command.equals("DeleteEvent")) {
    			
    			int id = Integer.parseInt(sc.nextLine().trim());
    			Event deletedEvent = event.deleteEvent(id);
    			if (deletedEvent!=null)System.out.println("Deleted event: "+deletedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("IDSearchEvent")) {
    			
    			int id = Integer.parseInt(sc.nextLine().trim());
    			Event searchedEvent = event.getEvent(id);
    			if (searchedEvent!=null)System.out.println("Event was found: "+searchedEvent.toString());
    			else System.out.println(id +" does not exist." );
    			
    		}else if(command.equals("NameSearchEvent")) {
    			
    			String name = sc.nextLine().trim();
    			Event searchedEvent = event.searchEvent(name);
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
    			Event editedEvent = event.editEvent(id, changes, fields, texts);
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
    			Event editedEvent = event.editEvent(name, changes, fields, texts);
    			if (editedEvent!=null)System.out.println("Event was edited: "+editedEvent.toString());
    			else System.out.println(name +" does not exist." );
    		}else {
    			System.out.println("Wrong command");
    			if (sc.hasNextLine())sc.nextLine();
    		}
    	}
    	sc.close();
    	System.out.println();
    	System.out.println("Test ended.");
	}*/
}
