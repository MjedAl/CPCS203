
public class CourseLab {

    private int LabID;
    private String labName;
    private double hours;

    // ---------------------- Consturtor ----------------------
    public CourseLab(int LabID, String labName, double hours) {
        this.LabID = LabID;
        this.labName = labName;
        this.hours = hours;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getLabID() {
        return LabID;
    }

    public void setLabID(int LabID) {
        this.LabID = LabID;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
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
        return " Labe Code: " + LabID + ", Lab Name: " + labName + ", Credit Hour :" + hours;
        //        ^^ not sure if this should be "Labe" or "Lab"
    }

}
