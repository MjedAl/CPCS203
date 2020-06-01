
public class ExamVenue {

    private int examVenueNo;
    private String floor;
    private int buldingNo;

    // ---------------------- Consturtor ----------------------
    public ExamVenue(int examVenueNo, String floor, int buldingNo) {
        this.examVenueNo = examVenueNo;
        this.floor = floor;
        this.buldingNo = buldingNo;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getExamVenueNo() {
        return examVenueNo;
    }

    public void setExamVenueNo(int examVenueNo) {
        this.examVenueNo = examVenueNo;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getBuldingNo() {
        return buldingNo;
    }

    public void setBuldingNo(int buldingNo) {
        this.buldingNo = buldingNo;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        return "Exam Venue Details are as follows:\r\n Exam Venue No.: " + examVenueNo + ", Floor: " + floor + ", Building No.:" + buldingNo;
    }

}
