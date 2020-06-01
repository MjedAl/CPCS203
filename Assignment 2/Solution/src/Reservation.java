
import java.util.Date;

public class Reservation {

    private String reservation_code;
    private String pick_up_location;
    private String drop_of_location;
    private Date pick_up;
    private Date drop_of;
    private Date date_of_reservation;
    private Customer customer;
    private Car car;
    private Service additional_services = null;

    public Reservation(Date pick_up, Date drop_of, String pick_up_location, String drop_of_location) {
        this.pick_up_location = pick_up_location;
        this.drop_of_location = drop_of_location;
        this.pick_up = pick_up;
        this.drop_of = drop_of;
    }

    public String getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(String reservation_code) {
        this.reservation_code = reservation_code;
    }

    public String getPick_up_location() {
        return pick_up_location;
    }

    public void setPick_up_location(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public String getDrop_of_location() {
        return drop_of_location;
    }

    public void setDrop_of_location(String drop_of_location) {
        this.drop_of_location = drop_of_location;
    }

    public Date getPick_up() {
        return pick_up;
    }

    public void setPick_up(Date pick_up) {
        this.pick_up = pick_up;
    }

    public Date getDrop_of() {
        return drop_of;
    }

    public void setDrop_of(Date drop_of) {
        this.drop_of = drop_of;
    }

    public Date getDate_of_reservation() {
        return date_of_reservation;
    }

    public void setDate_of_reservation(Date date_of_reservation) {
        this.date_of_reservation = date_of_reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Service getAdditional_services() {
        return additional_services;
    }

    public void setAdditional_services(Service additional_services) {
        this.additional_services = additional_services;
    }

    public String PrintInvoiceDetails() { // this method will set all the invoice details for printing. 
        String ReturnMe = "--------------- Invoice Details ---------------\r\n";

        // Get num of Days
        long Diff = (this.drop_of.getTime() - this.pick_up.getTime());
        int NumOfDays = (int) (Diff / (1000 * 60 * 60 * 24));
        ReturnMe += "Number of reserved days: " + NumOfDays + "\r\n";

        // Get Intial Total
        double Total = car.getRate() * NumOfDays;
        if (car.getType().equalsIgnoreCase("Luxury")) { // if the car is Luxury a 10% will be added
            Total += (Total * .10);
        }
        ReturnMe += " Intial Total: " + Total + "\r\n";

        // only if there's Additonal Serivce.
        if (additional_services != null) {
            ReturnMe += "--------------- Additional Services Price ---------------\r\n";
            Total += additional_services.getServiceRate();
            ReturnMe += " Total After additional Services  :" + Total + "\r\n";
        }

        // Final Paymet after discont
        int CustomerCode = customer.getCustomerCode();
        char FirstDigit = Integer.toString(CustomerCode).charAt(0);
        if (FirstDigit == '9' || FirstDigit == '8' || FirstDigit == '7') {
            Total -= (Total * .20);
        } else if (FirstDigit == '6' || FirstDigit == '5' || FirstDigit == '4') {
            Total -= (Total * .15);
        } else if (FirstDigit == '3' || FirstDigit == '2' || FirstDigit == '1' || FirstDigit == '0') {
            Total -= (Total * .10);
        }
        ReturnMe += "--------------- Final Payment after Discount ---------------\r\n";
        ReturnMe += " Final Total  :" + Total + "\r\n";

        return ReturnMe;
    }

}
