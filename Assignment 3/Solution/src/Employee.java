

public class Employee extends Person {

    private String jobTitle;
    private int officeNumber;
    private Boolean onLeave;

    // ---------------------- Consturtor ----------------------
    public Employee(String jobTitle, int officeNumber, boolean onLeave, int id, String name, String nationality, int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay, char gender, int phone, String address) {
        super(id, name, nationality, dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay, gender, phone, address);
        this.jobTitle = jobTitle;
        this.officeNumber = officeNumber;
        this.onLeave = onLeave;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Boolean getOnLeave() {
        return onLeave;
    }

    public void setOnLeave(Boolean onLeave) {
        this.onLeave = onLeave;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        return super.toString() + "\r\nJob Title: " + jobTitle + ", Office Number: " + officeNumber + ", On Leave : " + onLeave;
    }

}
