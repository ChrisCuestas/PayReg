package human;

public class Person {

    public enum NotifWay{
        SMS,
        WHATSAPP,
        EMAIL,
    }

    private String id; //This ID is to handle the data within a Key

    //Personal information
    private String firstName;
    private String lastName1;
    private String lastName2;
    private long phone;
    private String eMail;
    private NotifWay notifWay;

    public Person(String id, 
    		String firstName, 
    		String lastName1, 
    		String lastName2, 
    		long phone, 
    		String eMail, 
    		String notifWay) {
        this.id = id;
    	this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.phone = phone;
        this.eMail = eMail;
        if(notifWay.equals("SMS"))
			this.notifWay=NotifWay.SMS;
		else if(notifWay.equals("WHATSAPP")) 
			this.notifWay=NotifWay.WHATSAPP;
		else this.notifWay=NotifWay.EMAIL;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public long getPhone() {
        return phone;
    }

    protected void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEMail() {
        return eMail;
    }

    protected void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public NotifWay getNotifWay() {
        return notifWay;
    }

    protected void setNotifWay(NotifWay notifWay) {
        this.notifWay = notifWay;
    }

	@Override
	public String toString() {
		return  id + ", " + firstName + ", " + lastName1 + ", " + lastName2	+ ", " + 
				phone + ", " + eMail + ", " + notifWay;
	} 
}

