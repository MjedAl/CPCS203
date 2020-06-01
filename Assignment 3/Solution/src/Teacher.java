
public class Teacher extends Employee {

    private String degree;
    private String department;
    private double teachingHours;

    // ---------------------- Consturtor ----------------------
    public Teacher(String degree, String department, double teachingHours, String jobTitle, int officeNumber, boolean onLeave, int id, String name, String nationality, int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay, char gender, int phone, String address) {
        super(jobTitle, officeNumber, onLeave, id, name, nationality, dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay, gender, phone, address);
        this.degree = degree;
        this.department = department;
        this.teachingHours = teachingHours;
    }

    // ---------------------- Setters and Getters ----------------------
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(double teachingHours) {
        this.teachingHours = teachingHours;
    }

    // ---------------------- Other Methods ----------------------
    public String toString() {
        return super.toString() + "\r\n , Degree: " + degree + ", Department: " + department + ", Teaching Hours :" + teachingHours;
    }
}
