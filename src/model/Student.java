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
    public Student(String name, String surname, String personalCode) {
        idCounter++;
        this.stud_ID = idCounter;
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
    }

    // GET method
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

    // SET method
    public void setName(String name) {
        if(name != null && name.matches("[a-zA-Z]+"))
            this.name = name;
        else
            this.name = "Unknown";
    }

    public void setSurname(String surname) {
        if(surname != null && surname.matches("[a-zA-Z]+"))
            this.surname = surname;
        else
            this.surname = "Unknown";
    }

    public void setPersonalCode(String personalCode) {
        if(personalCode != null && personalCode.matches("\\d{11}"))
            this.personalCode = personalCode;
        else
            this.personalCode = "00000000000";
    }

    // toString method
    public String toString() {
        return "Student ID: " + stud_ID +
                ", Name: " + name + " " + surname +
                ", Personal Code: " + personalCode;
    }
}