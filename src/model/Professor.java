package model;

public class Professor extends Person {

    private static long idCounter = 0;
    private long p_ID;
    private String degree;

    // No-argument constructor
    public Professor() {
        super();
        idCounter++;
        this.p_ID = idCounter;
        this.degree = "B";
    }

    // Argument constructor
    public Professor(String name, String surname, String degree) {
        super(name, surname);
        idCounter++;
        this.p_ID = idCounter;
        this.degree = degree;
    }

    // Get method
    public long getProfID() {
        return p_ID;
    }

    public String getDegree() {
        return degree;
    }

    // Set method
    public void setDegree(String inputDegree) {
        if (inputDegree != null && inputDegree.length() > 1)
            this.degree = inputDegree;
        else
            this.degree = "B";
    }

    // toString method
    public String toString() {
        return "Professor ID: " + p_ID + ", " + super.toString() + ", Degree: " + degree;
    }
}