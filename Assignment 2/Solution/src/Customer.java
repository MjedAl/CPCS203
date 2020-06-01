

public class Customer {

    private String first_name;
    private String last_name;
    private String email;
    private long creditCard;
    private int CustomerCode;

    public Customer(String first_name, String last_name, String email, long creditCard, int CustomerCode) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.creditCard = creditCard;
        this.CustomerCode = CustomerCode;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public int getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(int CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

}
