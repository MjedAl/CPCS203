
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Event {

    private String Name;
    private Date SDate;
    private Date EDate;
    private double Price;
    private String City;
    private String Address;
    private String TargetedAudince;
    private int AvailbleTickets;

    // ---------------------- Consturtor ----------------------
    public Event(String Name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudince, int AvailbleTickets) {
        this.Name = Name;
        this.SDate = SDate;
        this.EDate = EDate;
        this.Price = Price;
        this.City = City;
        this.Address = Address;
        this.TargetedAudince = TargetedAudince;
        this.AvailbleTickets = AvailbleTickets;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getSDate() {
        return SDate;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTargetedAudince() {
        return TargetedAudince;
    }

    public void setTargetedAudince(String TargetedAudince) {
        this.TargetedAudince = TargetedAudince;
    }

    public int getAvailbleTickets() {
        return AvailbleTickets;
    }

    public void setAvailbleTickets(int AvailbleTickets) {
        this.AvailbleTickets = AvailbleTickets;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        SimpleDateFormat MyPrintDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Name:" + Name + ", Dates:" + MyPrintDateFormat.format(SDate) + " - " + MyPrintDateFormat.format(EDate) + ", City: " + City + ", Address: " + Address + ", Price: " + Price + ", Target Audience: " + TargetedAudince + ", Tickets Available: " + AvailbleTickets;
    }
}
