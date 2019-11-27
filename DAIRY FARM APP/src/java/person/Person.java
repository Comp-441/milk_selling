package person;

import java.sql.Date;



public abstract class Person {
    private String  firstName;
    private String  secondName;
    private String  phoneNumber;
    private Date    dateAdded;

    public Person(){
       this.firstName="firstName";
       this.secondName="secondName";
       this.phoneNumber="phoneNumber";
       this.dateAdded=new Date(System.currentTimeMillis());
    }

    public Person(String firstName, String secondName, String phoneNumber){
        this.firstName   =firstName;
        this.secondName  =secondName;
        this.phoneNumber =phoneNumber;
        this.dateAdded   = new Date(System.currentTimeMillis());

    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    
    


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
