
import java.text.SimpleDateFormat;
import java.util.Date;

public class Festival extends Event implements Comparable<Festival> {

    private String[] FoodVenus;
    private String[] Activity;

    // ---------------------- Consturtor ----------------------
    public Festival(String Name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudince, int AvailbleTickets, String[] FoodVenus, String[] Activity) {
        super(Name, SDate, EDate, Price, City, Address, TargetedAudince, AvailbleTickets);
        this.Activity = Activity;
        this.FoodVenus = FoodVenus;
    }

    // ---------------------- Setters and Getters ----------------------
    public String[] getFoodVenus() {
        return FoodVenus;
    }

    public void setFoodVenus(String[] FoodVenus) {
        this.FoodVenus = FoodVenus;
    }

    public String[] getActivity() {
        return Activity;
    }

    public void setActivity(String[] Activity) {
        this.Activity = Activity;
    }
    
    // ---------------------- Other Methods ----------------------
    public String GetPrintedFoodVenues() {
        String Return = "[";
        for (int i = 0; i < FoodVenus.length; i++) {
            Return += FoodVenus[i];
            if (!(i == FoodVenus.length - 1)) {//so i dont print "," on the last one
                Return += ", ";
            }
        }
        return Return + "]";
    }

    public String GetPrintedActivities() {
        String Return = "[";
        for (int i = 0; i < Activity.length; i++) {
            Return += Activity[i];
            if (!(i == Activity.length - 1)) {//so i dont print "," on the last one
                Return += ", ";
            }
        }
        return Return + "]";
    }

    @Override
    public String toString() {
        return "AddingFestival{" + super.toString() + ", FoodVenues: " + GetPrintedFoodVenues() + ", Activities: " + GetPrintedActivities() + "}  was successfully completed ";
    }

    public String PrintDetails() {
        SimpleDateFormat MyPrintDateFormat = new SimpleDateFormat("dd/MM/yy");
        return (String.format("%-20s\t\t %s-%s\t %-30s \t %-20s \t\t %d", super.getName(), MyPrintDateFormat.format(super.getSDate()), MyPrintDateFormat.format(super.getEDate()), GetPrintedFoodVenues(), GetPrintedActivities(), super.getAvailbleTickets()));
    }

    @Override
    public int compareTo(Festival x) {
        return super.getSDate().compareTo(x.getSDate());
    }

}
