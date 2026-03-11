package model;

public class Student extends Person {

    private static long idCounter = 10000;
    private long stud_ID;
    private String personalCode;

    // No-argument constructor
    public Student() {
        super();
        idCounter++;
        this.stud_ID = idCounter;
        this.personalCode = "000000-00000";
    }

    // Argument constructor
    public Student(String name, String surname, String personalCode) {
        super(name, surname);
        idCounter++;
        this.stud_ID = idCounter;
        this.personalCode = personalCode;
    }

    // Get method
    public long getStudentID() {
        return stud_ID;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    // Set method
    public void setPersonalCode(String inputPersonalCode) {
        if (inputPersonalCode != null && inputPersonalCode.matches("^\\d{6}-\\d{5}$")) {
            this.personalCode = inputPersonalCode;
        } else {
            this.personalCode = "000000-00000";
        }
    }

    // toString method
    public String toString() {
        return "Student ID: " + stud_ID + ", " + super.toString() + ", Personal Code: " + personalCode;
    }
}