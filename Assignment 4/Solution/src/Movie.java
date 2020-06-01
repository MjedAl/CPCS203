
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie extends Event implements Comparable<Movie> {

    private String Language;
    private double Rating;
    private String Genre;
    private Actor Actor;

    // ---------------------- Consturtor ----------------------
    public Movie(String Name, Date SDate, Date EDate, double Price, String City, String Address, String Language, String TargetedAudince, double Rating, int AvailbleTickets, String Genre, Actor Actor) {
        super(Name, SDate, EDate, Price, City, Address, TargetedAudince, AvailbleTickets);
        this.Language = Language;
        this.Rating = Rating;
        this.Genre = Genre;
        this.Actor = Actor;

    }

    // ---------------------- Setters and Getters ----------------------
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public Actor getActor() {
        return Actor;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

    // ---------------------- Other Methods ----------------------
    public String PrintDetails() {
        SimpleDateFormat MyPrintDateFormat = new SimpleDateFormat("dd/MM/yy");
        return (String.format("%-20s\t\t %s-%s\t%-20s %.1f\t\t\t %d", super.getName(), MyPrintDateFormat.format(super.getSDate()), MyPrintDateFormat.format(super.getEDate()), Actor.getName(), Rating, super.getAvailbleTickets()));
    }

    @Override
    public String toString() {
        return "AddingMovie{" + super.toString() + ",Rating:" + Rating + ", Language:" + Language + ", Genre:" + Genre + ", Actor: " + Actor.getName() + " } was successfully completed ";
    }

    @Override
    public int compareTo(Movie X) {
        if (this.Rating < X.getRating()) {
            return 1;
        } else if (this.Rating > X.getRating()) {
            return -1;
        } else {
            return 0;
        }
    }
}
