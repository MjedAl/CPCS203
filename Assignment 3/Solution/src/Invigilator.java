
public class Invigilator extends Employee {

    private int invigilatorExperienceYears;
    private String invigilatorSkills;

    // ---------------------- Consturtor ----------------------
    public Invigilator(int invigilatorExperienceYears, String invigilatorSkills, String jobTitle, int officeNumber, boolean onLeave, int id, String name, String nationality, int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay, char gender, int phone, String address) {
        super(jobTitle, officeNumber, onLeave, id, name, nationality, dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay, gender, phone, address);
        this.invigilatorExperienceYears = invigilatorExperienceYears;
        this.invigilatorSkills = invigilatorSkills;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getInvigilatorExperienceYears() {
        return invigilatorExperienceYears;
    }

    public void setInvigilatorExperienceYears(int invigilatorExperienceYears) {
        this.invigilatorExperienceYears = invigilatorExperienceYears;
    }

    public String getInvigilatorSkills() {
        return invigilatorSkills;
    }

    public void setInvigilatorSkills(String invigilatorSkills) {
        this.invigilatorSkills = invigilatorSkills;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        return super.toString() + "\r\n Year(s) of Invigilaton Experience: " + invigilatorExperienceYears + ", Invigilaton Expertise: " + invigilatorSkills;
    }

}
