

import java.util.ArrayList;

public class Booking {

    private String BookingID;
    private Customer Customer;
    private ArrayList<Event> Events;
    private double discount;
    private double finalTotalPrice;

    // ---------------------- Consturtor ----------------------
    public Booking(String BookingID, Customer Customer, ArrayList<Event> Events) {
        this.BookingID = BookingID;
        this.Customer = Customer;
        this.Events = Events;

        for (int i = 0; i < Events.size(); i++) { // so we a confirmed ticket so we must reduce the number of availabe tickets fpr each event 
            Events.get(i).setAvailbleTickets(((Events.get(i).getAvailbleTickets()) - 1));
        }
    }

    // ---------------------- Setters and Getters ----------------------
    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.Events = Events;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public String getBookingID() {
        return BookingID;
    }

    public double getFinalTotalPrice() {
        return finalTotalPrice;
    }
    
    // ---------------------- Other Methods ----------------------
    public double getDiscount() {
        if (Customer.GetCustomerAge() <= 3) {
            return 100;
        } else if (Customer.GetCustomerAge() <= 15) {
            return 50;
        }
        return discount;
    }

    @Override
    public String toString() {
        String R = "------------------------- Invoice Details -------------------------\r\n"
                + "Booking#: " + BookingID + "\r\n"
                + "Customer #:" + Customer.getCustomerID() + "\r\n"
                + "-------------------------------------------------------------------\r\n"
                + "Event               	Price   	Discount	Final_price\r\n";
        double totalBeforeDiscount = 0;
        int DiscountedEvents = 0;

        for (int i = 0; i < Events.size(); i++) {
            double Discount = 0;
            double Price = (Events.get(i).getPrice());
            double FinalPrice = Price;
            if (Events.get(i) instanceof Festival) {
                Discount = getDiscount();
            }
            if (Discount > 0 && Discount != 100) {
                DiscountedEvents++;
                FinalPrice *= (Discount / 100);
            }
            if (Discount == 100) {
                DiscountedEvents++;
                FinalPrice = 0;
            }
            R += String.format("%-25s %.2f \t %.1f%% \t %.2f\r\n", Events.get(i).getName(), Price, Discount, FinalPrice);

            totalBeforeDiscount += Price;
            finalTotalPrice += FinalPrice;

        }
        R += "-------------------------------------------------------------------\r\n";
        R += "Number of discount items: " + DiscountedEvents + "\r\n";
        R += String.format("- Total Price: %.2f\r\n", totalBeforeDiscount);
        R += String.format("- Final Price: %.2f\r\n", finalTotalPrice);
        R += String.format("- Saving Amount: %.2f\r\n", totalBeforeDiscount - finalTotalPrice);
        R += "-------------------------------------------------------------------\r\n\r\n";

        return R;
    }
}
