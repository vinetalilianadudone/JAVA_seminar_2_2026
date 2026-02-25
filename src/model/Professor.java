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
    public Professor(String inputName, String inputSurname, String inputDegree) {
        idCounter++;
        this.p_ID = idCounter;
        setName(inputName);
        setSurname(inputSurname);
        setDegree(inputDegree);
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
    public void setName(String inputName) {
        if (inputName != null && inputName.matches("[a-zA-Z]+"))
            this.name = inputName;
        else
            this.name = "Unknown";
    }

    public void setSurname(String inputSurname) {
        if (inputSurname != null && inputSurname.matches("[a-zA-Z]+"))
            this.surname = inputSurname;
        else
            this.surname = "Unknown";
    }

    public void setDegree(String inputDegree) {
        if (inputDegree != null && inputDegree.length() > 1)
            this.degree = inputDegree;
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