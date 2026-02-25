package model;

public class Professor {

    private static long idCounter = 0;

    private long p_ID;
    private String name;
    private String surname;
    private String degree;

    // No-argument constructor
    public Professor() {
        idCounter++;
        this.p_ID = idCounter;
        this.name = "Unknown";
        this.surname = "Unknown";
        this.degree = "B";
    }

    // Argument constructor
    public Professor(String name, String surname, String degree) {
        idCounter++;
        this.p_ID = idCounter;
        setName(name);
        setSurname(surname);
        setDegree(degree);
    }

    // Get method
    public long getProfID() {
        return p_ID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getDegree() {
        return degree;
    }

    // Set method
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

    public void setDegree(String degree) {
        if(degree != null && degree.length() > 1)
            this.degree = degree;
        else
            this.degree = "B";
    }

    // toString method
    public String toString() {
        return "Professor ID: " + p_ID +
                ", Name: " + name + " " + surname +
                ", Degree: " + degree;
    }
}