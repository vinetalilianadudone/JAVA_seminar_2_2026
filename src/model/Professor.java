package model;

public class Professor extends Person {

	// variables
    private long professorId;
    private ProfessorDegree degree;
    private static long counter = 0;

    // get and set methods
    public long getProfessorId() { 
    	return professorId; 
    }
    
    public ProfessorDegree getDegree() { 
    	return degree; 
    	}

    private void generateId() {
        professorId = counter++;
    }

    public void setDegree(ProfessorDegree degree) {
        if (degree != null) 
        	this.degree = degree;
        else 
        	this.degree = ProfessorDegree.unknown;
    }

    // no-argument constructor
    public Professor() {
        super();
        generateId();
        setDegree(ProfessorDegree.master);
    }

    // argument constructor
    public Professor(String n, String s, String c, ProfessorDegree d) {
        super(n, s, c);
        generateId();
        setDegree(d);
    }

    // to string method
    public String toString() {
        return professorId + ": " + super.toString() + " " + degree;
    }
}