package model;

public class Student {

    private static long idCounter = 10000;

    private long stud_ID;
    private String name;
    private String surname;
    private String personalCode;

    // No-argument constructor
    public Student() {
        idCounter++;
        this.stud_ID = idCounter;
        this.name = "Unknown";
        this.surname = "Unknown";
        this.personalCode = "00000000000";
    }

    // Argument constructor
    public Student(String inputName, String inputSurname, String inputPersonalCode) {
        idCounter++;
        this.stud_ID = idCounter;
        setName(inputName);
        setSurname(inputSurname);
        setPersonalCode(inputPersonalCode);
    }

    // Get method
    public long getStudentID() {
        return stud_ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    // Set method
    public void setName(String inputName) {
        if (inputName != null && inputName.matches("[a-zA-Z]+")) {
            this.name = inputName;
        } else {
            this.name = "Unknown";
        }
    }

    public void setSurname(String inputSurname) {
        if (inputSurname != null && inputSurname.matches("[a-zA-Z]+")) {
            this.surname = inputSurname;
        } else {
            this.surname = "Unknown";
        }
    }

    public void setPersonalCode(String inputPersonalCode) {
        if (inputPersonalCode != null && inputPersonalCode.matches("\\d{11}")) {
            this.personalCode = inputPersonalCode;
        } else {
            this.personalCode = "00000000000";
        }
    }

    // toString method
    public String toString() {
        return "Student ID: " + stud_ID +
                ", Name: " + name + " " + surname +
                ", Personal Code: " + personalCode;
    }
}