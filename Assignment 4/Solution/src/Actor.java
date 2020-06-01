
public class Actor {

    private String Name;
    private char Gender;
    private int BirthYear;

    // ---------------------- Consturtor ----------------------
    public Actor(String Name, char Gender, int BirthYear) {
        this.Name = Name;
        this.Gender = Gender;
        this.BirthYear = BirthYear;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int BirthYear) {
        this.BirthYear = BirthYear;
    }

}
