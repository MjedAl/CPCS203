
public class Person {

    private int id;
    private String name;
    private String nationality;
    private int dateOfBirthYear;
    private int dateOfBirthMonth;
    private int dateOfBirthDay;
    private char gender;
    private int phone;
    private String address;
    private String DateOfBirth;

    // ---------------------- Consturtor ----------------------
    public Person(int id, String name, String nationality, int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay, char gender, int phone, String address) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirthYear = dateOfBirthYear;
        this.dateOfBirthMonth = dateOfBirthMonth;
        this.dateOfBirthDay = dateOfBirthDay;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.DateOfBirth = dateOfBirthYear + "-" + dateOfBirthMonth + "-" + dateOfBirthDay;
    }

    // ---------------------- Setters and Getters ----------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirthYear, int dateOfBirthMonth, int dateOfBirthDay) {
        this.DateOfBirth = dateOfBirthYear + "-" + dateOfBirthMonth + "-" + dateOfBirthDay;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ---------------------- Other Methods ----------------------
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Nationality :" + nationality + ",  Date of Birth :" + DateOfBirth + ", Gender:" + gender + ", Phone: " + phone + ", Address:" + address;
    }
}
