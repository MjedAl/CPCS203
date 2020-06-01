

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

    private String CustomerID;
    private String name;
    private char gender;
    private String email;
    private Date DateOfBith;
    private String City;
    
    // ---------------------- Consturtor ----------------------
    public Customer(String CustomerID, String name, char gender, String City, String email, Date DateOfBith) {
        this.CustomerID = CustomerID;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.DateOfBith = DateOfBith;
        this.City = City;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBith() {
        return DateOfBith;
    }

    public void setDateOfBith(Date DateOfBith) {
        this.DateOfBith = DateOfBith;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        SimpleDateFormat MyPrintDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "AddingCustomerCustomer Number :" + CustomerID + " Name: " + name + ", Email: " + email + ", BateOfBirth: " + MyPrintDateFormat.format(DateOfBith) + "} was successfully completed ";
    }

    public int GetCustomerAge() {
        java.util.Date now = new java.util.Date();
        long Diff = now.getTime() - DateOfBith.getTime();
        int NumOfYears = (int) (Diff / 3.15e10);
        return NumOfYears;
    }
}
