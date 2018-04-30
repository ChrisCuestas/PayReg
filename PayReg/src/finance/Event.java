package finance;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;

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

	protected void setCost(int cost) {
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

	protected void isActive(boolean isActive) {
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
	
	@Override
	public String toString() {
		return "[" + name + ", " + isActive + ", " + numPeople + " personas, " + cost
				+ ", " + this.getCostByPerson() + " por persona, " + totalCollected + ", faltan "+ this.getRemains()+"]";
	}
	
}
