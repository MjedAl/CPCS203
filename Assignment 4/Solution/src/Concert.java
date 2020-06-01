
import java.util.Date;

public class Concert extends Event {

    private String performers;

    // ---------------------- Consturtor ----------------------
    public Concert(String Name, Date SDate, Date EDate, String City, String Address, double Price, int AvailbleTickets, String TargetedAudince, String performers) {
        super(Name, SDate, EDate, Price, City, Address, TargetedAudince, AvailbleTickets);
        this.performers = performers;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    @Override
    public String toString() {
        return "AddingConcert{" + super.toString() + ", Performers: " + performers + "  } was successfully completed ";
    }

}
