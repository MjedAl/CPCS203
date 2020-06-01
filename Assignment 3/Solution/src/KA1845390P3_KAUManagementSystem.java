
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KA1845390P3_KAUManagementSystem {

    // i will use these to count of the numbers, so i when where to put an object in array;
    static int NuOfTeacher = 0;
    static int NuOfInvigilators = 0;
    static int NuOfExamVenues = 0;
    static int NuOfCoursesLabs = 0;
    static int NuOfCourses = 0;
    static int NuOfStudents = 0;

    // --------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws FileNotFoundException {
        File inputTxt = new File("input.txt");
        if (!inputTxt.exists()) {
            System.out.println("Error 001 (input.txt) file is not found, Please try again.");
            System.exit(1);
        }
        Scanner TxtInput = new Scanner(inputTxt); // Scanner to read from input.txt

        // Making all the array of objects
        Teacher[] Teachers = new Teacher[TxtInput.nextInt()];
        Invigilator[] Invigilators = new Invigilator[TxtInput.nextInt()];
        ExamVenue[] ExamVenues = new ExamVenue[TxtInput.nextInt()];
        CourseLab[] CoursesLabs = new CourseLab[TxtInput.nextInt()];
        Course[] Courses = new Course[TxtInput.nextInt()];
        Student[] Students = new Student[TxtInput.nextInt()];

        PrintWriter Pen = new PrintWriter(new File("StudentWrite.txt")); // PrintWriter to print in StudentWrite.txt  
        Pen.println("--------------- Welcome to KAU Management System ---------------");
        String Commands = "";
        do {
            Commands = TxtInput.next();
            switch (Commands) {
                case "Add_Teacher":
                    Add_TeacherCMD(Pen, TxtInput, Teachers);
                    break;
                case "Add_Invigilator":
                    Add_InvigilatorCMD(Pen, TxtInput, Invigilators);
                    break;
                case "Add_ExamVenue":
                    Add_ExamVenueCMD(Pen, TxtInput, ExamVenues);
                    break;
                case "Add_CourseLab":
                    Add_CourseLabCMD(Pen, TxtInput, CoursesLabs);
                    break;
                case "Add_Course":
                    Add_CourseCMD(Pen, TxtInput, Courses);
                    break;
                case "Add_Student":
                    Add_StudentCMD(Pen, TxtInput, Students);
                    break;
                case "Assign_Teacher_Student":
                    AssignTeacherStudentCMD(Pen, TxtInput, Teachers, Students);
                    break;
                case "Assign_ExamVenue_Student":
                    AssignExamValueStudentCMD(Pen, TxtInput, ExamVenues, Students);
                    break;
                case "Assign_Invigilator_Student":
                    AssignInvigilatorStudentCMD(Pen, TxtInput, Invigilators, Students);
                    break;
                case "Assign_CourseLab_Student":
                    AssignCourseLabStudentCMD(Pen, TxtInput, CoursesLabs, Students);
                    break;
                case "Assign_Course_Student":
                    AssignCourseStudentCMD(Pen, TxtInput, Courses, Students);
                    break;
                case "Print_Report":
                    Print_Report(Students);
                    break;
            }
        } while (!Commands.equalsIgnoreCase("quit"));
        Pen.println("Thank you for using KAU Management System, Good Bye!");
        Pen.flush();
        Pen.close();

    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_TeacherCMD(PrintWriter pen, Scanner in, Teacher[] Teachers) {
        Teachers[NuOfTeacher] = new Teacher(in.next(), in.next(), in.nextDouble(), in.next(), in.nextInt(), in.nextBoolean(), in.nextInt(), in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.next().charAt(0), in.nextInt(), in.next());
        pen.println("Command Add_Teacher: Add a new doctor record in the System");
        pen.println(Teachers[NuOfTeacher]);
        pen.println("\r\n----------------------------------------------------------------");
        NuOfTeacher++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_InvigilatorCMD(PrintWriter pen, Scanner in, Invigilator[] Invigilators) {
        Invigilators[NuOfInvigilators] = new Invigilator(in.nextInt(), in.next(), in.next(), in.nextInt(), in.nextBoolean(), in.nextInt(), in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.next().charAt(0), in.nextInt(), in.next());
        pen.println("Command Add_Invigilator: Add a new invigilator record in the System");
        pen.println(Invigilators[NuOfInvigilators]);
        pen.println("\r\n----------------------------------------------------------------");
        NuOfInvigilators++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_ExamVenueCMD(PrintWriter pen, Scanner in, ExamVenue[] ExamVenues) {
        ExamVenues[NuOfExamVenues] = new ExamVenue(in.nextInt(), in.next(), in.nextInt());
        pen.println("Command Add_ExamVenue: Add a new exam venue record in the System");
        pen.println(ExamVenues[NuOfExamVenues]);
        pen.println("\r\n----------------------------------------------------------------");
        NuOfExamVenues++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_CourseLabCMD(PrintWriter pen, Scanner in, CourseLab[] CoursesLabs) {
        CoursesLabs[NuOfCoursesLabs] = new CourseLab(in.nextInt(), in.next(), in.nextDouble());
        pen.println("Command Add_CourseLab: Add a new course lab record in the System");
        pen.println(CoursesLabs[NuOfCoursesLabs]);
        pen.println("\r\n----------------------------------------------------------------");
        NuOfCoursesLabs++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_CourseCMD(PrintWriter pen, Scanner in, Course[] Courses) {
        Courses[NuOfCourses] = new Course(in.nextInt(), in.next(), in.nextDouble());
        pen.println("Command Add_Course: Add a new course record in the System");
        pen.println(Courses[NuOfCourses]);
        pen.println("\r\n----------------------------------------------------------------");
        NuOfCourses++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void Add_StudentCMD(PrintWriter pen, Scanner in, Student[] Students) {
        Students[NuOfStudents] = new Student(in.next(), in.nextInt(), in.nextDouble(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextInt(), in.next().charAt(0), in.nextInt(), in.next(), in.nextInt(), in.nextInt());
        pen.println("Command Add_Student: Add a new Student record in the System");
        pen.println(Students[NuOfStudents].printStudentBasicInfo());
        pen.println("\r\n----------------------------------------------------------------");
        NuOfStudents++;
    }

    // --------------------------------------------------------------------------------------------------
    public static void AssignTeacherStudentCMD(PrintWriter pen, Scanner in, Teacher[] Teachers, Student[] Students) {
        int TeacherID = in.nextInt();
        int StudentID = in.nextInt();
        // okay so we have TeacherId and StudentId now we have to find the index of these ids from Teacher array and Student array
        // teacher
        int TeacherIndex = -1;
        for (int i = 0; i < Teachers.length; i++) {
            if (Teachers[i].getId() == TeacherID) {
                TeacherIndex = i;
                break;
            }
        }
        // Student
        int StudentIndex = -1;
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getId() == StudentID) {
                StudentIndex = i;
                break;
            }
        }
        if (TeacherIndex == -1 || StudentIndex == -1) { // if no student or teacher is found (wrong data from input)
            pen.close();
            System.out.println("Error 002 - Wrong input At (Assign_Teacher_Student " + TeacherID + " " + StudentID + " )");
        } else {
            // assinging the right teacher to the right student
            Students[StudentIndex].setTeacher(Teachers[TeacherIndex]);
            pen.println("Command Assign_Teacher_Student: Successfully Processed by the System, Following are the details:");
            pen.println("\tStudent: " + Students[StudentIndex].getName());
            pen.println("\tAssigned to Teacher: " + Teachers[TeacherIndex].getName());
            pen.println("----------------------------------------------------------------");
        }

    }

    // --------------------------------------------------------------------------------------------------
    public static void AssignExamValueStudentCMD(PrintWriter pen, Scanner in, ExamVenue[] ExamVenues, Student[] Students) {
        // basiclly same as above method ;)
        int ExamVenueNumber = in.nextInt();
        int StudentID = in.nextInt();

        // Venue Number
        int ExamVenueNumberIndex = -1;
        for (int i = 0; i < ExamVenues.length; i++) {
            if (ExamVenues[i].getExamVenueNo() == ExamVenueNumber) {
                ExamVenueNumberIndex = i;
                break;
            }
        }
        // Student
        int StudentIndex = -1;
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getId() == StudentID) {
                StudentIndex = i;
                break;
            }
        }
        if (ExamVenueNumberIndex == -1 || StudentIndex == -1) { // if no student or exam venue is found (wrong data from input)
            pen.close();
            System.out.println("Error 003 - Wrong input At (Assign_ExamVenue_Student " + ExamVenueNumber + " " + StudentID + " )");
        } else {
            //assinging the right exam venue to the right student
            Students[StudentIndex].setExamVenue(ExamVenues[ExamVenueNumberIndex]);
            pen.println("Command Assign_ExamVenue_Student: Successfully Processed by the System, Following are the details:");
            pen.println("\tStudent: " + Students[StudentIndex].getName());
            pen.println("Assigned to ExamVenue: \r\n" + ExamVenues[ExamVenueNumberIndex]);
            pen.println("\r\n----------------------------------------------------------------");
        }

    }

    // --------------------------------------------------------------------------------------------------
    public static void AssignInvigilatorStudentCMD(PrintWriter pen, Scanner in, Invigilator[] Invigilators, Student[] Students) {
        // also same as above method :)
        int InvigilatorsID = in.nextInt();
        int StudentID = in.nextInt();

        // Invigilators
        int InvigilatorsIndex = -1;
        for (int i = 0; i < Invigilators.length; i++) {
            if (Invigilators[i].getId() == InvigilatorsID) {
                InvigilatorsIndex = i;
                break;
            }
        }
        // Student
        int StudentIndex = -1;
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getId() == StudentID) {
                StudentIndex = i;
                break;
            }
        }
        if (InvigilatorsIndex == -1 || StudentIndex == -1) { // if no student or exam venue is found (wrong data from input)
            pen.close();
            System.out.println("Error 004 - Wrong input At (Assign_Invigilator_Student " + InvigilatorsID + " " + StudentID + " )");
        } else {
            //assinging the right exam Invigilators to the right student
            Students[StudentIndex].SetInvigilator(Invigilators[InvigilatorsIndex]);
            pen.println("Command Assign_Invigilator_Student: Successfully Processed by the System, Following are the details:");
            pen.println("\tStudent: " + Students[StudentIndex].getName());
            pen.println("Assigned to Invigilator: " + Invigilators[InvigilatorsIndex].getName());
            pen.println("----------------------------------------------------------------");
        }

    }

    // --------------------------------------------------------------------------------------------------
    public static void AssignCourseLabStudentCMD(PrintWriter pen, Scanner in, CourseLab[] CoursesLabs, Student[] Students) {
        pen.println("Command Assign_CourseLab_Student: Successfully Processed by the System, Following are the details:");

        int StudentID = in.nextInt();
        // Find the Student
        int StudentIndex = -1;
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getId() == StudentID) {
                StudentIndex = i;
                break;
            }
        }

        pen.println("\t Student: " + Students[StudentIndex].getName());

        int NuOfLab = Students[StudentIndex].getTotalCoruseLab(); // getting the number of labs for this student
        CourseLab[] Temp = new CourseLab[NuOfLab]; // making an array of lab courses to send it to this student later after adding al courses

        for (int i = 0; i < NuOfLab; i++) { // go tho all coruse (Ex: Student A have 4 labs)

            int inputLabCourse = in.nextInt(); // take the lab course number
            for (int j = 0; j < CoursesLabs.length; j++) { // searches for all Labs Courses

                if (inputLabCourse == CoursesLabs[j].getLabID()) { // if we found the course in the lab array 
                    Temp[i] = CoursesLabs[j]; // adding that course to the temp array
                    pen.println("		 Course Lab added:  " + CoursesLabs[j].toString() + "\r\n");
                    break;
                }
            }

        }
        pen.println("----------------------------------------------------------------");
        Students[StudentIndex].setCorseLab(Temp); // sending the temp array to the student
    }

    // --------------------------------------------------------------------------------------------------
    public static void AssignCourseStudentCMD(PrintWriter pen, Scanner in, Course[] Courses, Student[] Students) {
        // same as above method

        pen.println("Command Assign_Course_Student: Successfully Processed by the System, Following are the details:");

        int StudentID = in.nextInt();
        // Find the Student
        int StudentIndex = -1;
        for (int i = 0; i < Students.length; i++) {
            if (Students[i].getId() == StudentID) {
                StudentIndex = i;
                break;
            }
        }
        pen.println("\t Student: " + Students[StudentIndex].getName());

        int NuOfCourse = Students[StudentIndex].getTotalCoruse();
        Course[] Temp = new Course[NuOfCourse];

        for (int i = 0; i < NuOfCourse; i++) {
            int inputLabCourse = in.nextInt();
            for (int j = 0; j < Courses.length; j++) {
                if (inputLabCourse == Courses[j].getCourceCode()) {
                    Temp[i] = Courses[j];
                    pen.println("		 Course added:  " + Courses[j].toString() + "\r\n");
                    break;
                }
            }
        }
        pen.println("----------------------------------------------------------------");
        Students[StudentIndex].setCourse(Temp);
    }

    // --------------------------------------------------------------------------------------------------
    public static void Print_Report(Student[] Students) throws FileNotFoundException {
        // Make new folder to store all reports in it
        File Folder = new File("AllReportsFor" + Students.length + "Students");
        Folder.mkdirs();

        for (int i = 0; i < Students.length; i++) {
            String FileName = (Folder + "\\" + Students[i].getName().toUpperCase().charAt(0)) + "" + Students[i].getName().charAt(1) + "" + Students[i].getId() + "_Student_Report.txt";
            File Print = new File(FileName);
            PrintWriter Pen = new PrintWriter(Print);
            Pen.print(Students[i]);
            Pen.flush();
            Pen.close();
        }
    }
}
