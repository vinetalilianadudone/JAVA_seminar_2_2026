package model;

public class Grade {

    private static long idCounter = 200000;

    private long g_ID;
    private int value;
    private Student student;
    private Course course;

    // No-argument constructor
    public Grade() {
        idCounter++;
        this.g_ID = idCounter;
        this.value = 4;
        this.student = new Student();
        this.course = new Course();
    }

    // Argument constructor
    public Grade(int inputValue, Student inputStudent, Course inputCourse) {
        idCounter++;
        this.g_ID = idCounter;
        setValue(inputValue);
        setStudent(inputStudent);
        setCourse(inputCourse);
    }

    // Get method
    public long getGID() {
        return g_ID;
    }

    public int getValue() {
        return value;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    // Set method
    public void setValue(int inputValue) {
        if (inputValue >= 1 && inputValue <= 10)
            this.value = inputValue;
        else
            this.value = 4;
    }

    public void setStudent(Student inputStudent) {
        if (inputStudent != null)
            this.student = inputStudent;
        else
            this.student = new Student();
    }

    public void setCourse(Course inputCourse) {
        if (inputCourse != null)
            this.course = inputCourse;
        else
            this.course = new Course();
    }

    // toString method
    public String toString() {
        return "Grade ID: " + g_ID +
                ", Value: " + value +
                ", Student: " + student.getName() + " " + student.getSurname() +
                ", Course: " + course.getTitle();
    }
}