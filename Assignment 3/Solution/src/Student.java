
public class Student extends Person {

    private String department;
    private int semester;
    private double cgpa;
    private Teacher teacher;
    private Invigilator invigilator;
    private Course[] course;
    private CourseLab[] corseLab;
    private ExamVenue examVenue;
    private int entrollDateYear;
    private int entrollDateMonth;
    private int entrollDateDay;

    private int totalCoruse;
    private int totalCoruseLab;

    String entrollDate;

    // ---------------------- Consturtor ----------------------
    public Student(String department, int semester, double cgpa, int entrollDateYear, int entrollDateMonth, int entrollDateDay, int id, String name, String nationality, int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay, char gender, int phone, String address, int totalCoruse, int totalCoruseLab) {
        super(id, name, nationality, dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay, gender, phone, address);
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
        this.entrollDateYear = entrollDateYear;
        this.entrollDateMonth = entrollDateMonth;
        this.entrollDateDay = entrollDateDay;
        this.entrollDate = entrollDateYear + "-" + entrollDateMonth + "-" + entrollDateDay;
        this.totalCoruse = totalCoruse;
        this.totalCoruseLab = totalCoruseLab;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getTotalCoruse() {
        return totalCoruse;
    }

    public int getTotalCoruseLab() {
        return totalCoruseLab;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Invigilator getInvigilator() {
        return invigilator;
    }

    public void SetInvigilator(Invigilator invigilator) {
        this.invigilator = invigilator;
    }

    public Course[] getCourse() {
        return course;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }

    public CourseLab[] getCorseLab() {
        return corseLab;
    }

    public void setCorseLab(CourseLab[] corseLab) {
        this.corseLab = corseLab;
    }

    public ExamVenue getExamVenue() {
        return examVenue;
    }

    public void setExamVenue(ExamVenue examVenue) {
        this.examVenue = examVenue;
    }

    // ---------------------- Other Methods ----------------------
    public double getTotalCoruseHrs() {
        double total = 0;
        for (int i = 0; i < course.length; i++) {
            total += course[i].getHours();
        }
        return total;
    }

    public double getTotalCoruseLabHrs() {
        double total = 0;
        for (int i = 0; i < corseLab.length; i++) {
            total += corseLab[i].getHours();
        }
        return total;
    }

    public String printStudentBasicInfo() {
        return super.toString() + "\r\n"
                + "-------------------------------------------------------------------------------------------\r\n"
                + "Department: " + department + ", Semester:" + semester + "\r\n"
                + "CGPA:" + cgpa + "\r\n"
                + "Enrollment Date:" + entrollDate + "\r\n"
                + "-------------------------------------------------------------------------------------------";

    }

    public double calTotalHours() {
        return getTotalCoruseHrs() + getTotalCoruseLabHrs();
    }

    @Override
    public String toString() { // all student details to print it in the the file
        String Return = "";
        java.util.Date date = new java.util.Date();
        Return += "--------------- Welcome to KAU Management System ---------------"
                + "\r\n--------- Current Date : " + date
                + "\r\nCommand: Print_Report\r\n"
                + "\r\n		--- Student Detail are as Follows: ---\r\n" + printStudentBasicInfo()
                + "\r\n		--- Teacher Detail are as Follows: ---\r\n" + getTeacher() + "\r\n"
                + "-------------------------------------------------------------------------------------------"
                + "\r\n		--- Invigilator Detail are as Follows: ---\r\n" + getInvigilator()
                + "\r\n-------------------------------------------------------------------------------------------"
                + "\r\nCourse Lab Details are as follows:\r\n";

        for (CourseLab corseLab1 : corseLab) {
            Return += corseLab1 + "\r\n";
        }
        Return += "-------------------------------------------------------------------------------------------\r\n"
                + "Course Details are as follows:";
        for (Course course1 : course) {
            Return += "\r\n" + course1;
        }
        Return += "\r\n-------------------------------------------------------------------------------------------"
                + "\r\n" + getExamVenue()
                + "\r\n-------------------------------------------------------------------------------------------"
                + "\r\n		Total Hours :" + calTotalHours() + "\r\n	-----------------------------------\r\n\r\n\r\n";
        return Return;
    }

}
