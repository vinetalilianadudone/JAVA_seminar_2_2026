package model;

public class Student extends Person {

	// variables
    private long studentId;
    private static long studentCounter = 10000;

    // get and set methods
    public long getStudentId() { 
    	return studentId; 
    	}

    private void generateId() {
        studentId = studentCounter++;
    }

    // no-argument constructor
    public Student() {
        super();
        generateId();
    }

    // argument constructor
    public Student(String name, String surname, String code) {
        super(name, surname, code);
        generateId();
    }

    // to string method
    public String toString() {
        return studentId + ": " + super.toString();
    }
}