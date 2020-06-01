
public class Course {

    private int courceCode;
    private String courseTitle;
    private double hours;

    // ---------------------- Consturtor ----------------------
    public Course(int courceCode, String courseTitle, double hours) {
        this.courceCode = courceCode;
        this.courseTitle = courseTitle;
        this.hours = hours;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getCourceCode() {
        return courceCode;
    }

    public void setCourceCode(int courceCode) {
        this.courceCode = courceCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        return " Course Code: " + courceCode + ", Course Title: " + courseTitle + ", Credit Hours : " + hours;
    }

}
