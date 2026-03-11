package model;

public class Course {

    private static long idCounter = 100000;

    private long c_ID;
    private String title;
    private int creditPoints;
    private Professor professor;

    // No-argument constructor
    public Course() {
        idCounter++;
        this.c_ID = idCounter;
        this.title = "Unknown Course";
        this.creditPoints = 3;
        this.professor = new Professor();
    }

    // Argument constructor
    public Course(String title, int creditPoints, Professor professor) {
        idCounter++;
        this.c_ID = idCounter;
        this.title = title;
        this.creditPoints = creditPoints;
        this.professor = professor;
    }

    // Get method
    public long getCID() {
        return c_ID;
    }

    public String getTitle() {
        return title;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public Professor getProfessor() {
        return professor;
    }

    // Set method
    public void setTitle(String inputTitle) {
        if (inputTitle != null && !inputTitle.trim().isEmpty())
            this.title = inputTitle;
        else
            this.title = "Unknown Course";
    }

    public void setCreditPoints(int inputCreditPoints) {
        if (inputCreditPoints > 0 && inputCreditPoints <= 30)
            this.creditPoints = inputCreditPoints;
        else
            this.creditPoints = 3;
    }

    // toString method
    public String toString() {
        return "Course ID: " + c_ID + ", Title: " + title +
                ", Credit Points: " + creditPoints +
                ", Professor: " + professor;
    }
}