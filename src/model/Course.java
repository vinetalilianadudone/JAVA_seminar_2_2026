package model;

public class Course {

	// variables
    private long courseId;
    private String title;
    private byte creditPoints;
    private Professor professor;
    private static long counter = 100000;

    // get and set methods
    public long getCourseId() { 
    	return courseId;
    	}
    
    public String getTitle() { 
    	return title; 
    	}
    
    public byte getCreditPoints() { 
    	return creditPoints; 
    	}
    
    public Professor getProfessor() { 
    	return professor; 
    	}

    private void generateId() {
        courseId = counter++;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) 
        	this.title = title;
        else 
        	throw new IllegalArgumentException("Nepareizs kursa nosaukums");
    }

    public void setCreditPoints(byte cp) {
        if (cp >= 1 && cp <= 30) 
        	creditPoints = cp;
        else 
        	throw new IllegalArgumentException("Nepareizi kredītpunkti");
    }

    public void setProfessor(Professor p) {
        if (p != null) 
        	professor = p;
        else 
        	throw new IllegalArgumentException("Profesors nevar būt null");
    }
    
    // no-argument constructor
    public Course() {
        this("JAVA", (byte)6, new Professor());
    }

    // argument constructor
    public Course(String t, byte cp, Professor p) {
        generateId();
        setTitle(t);
        setCreditPoints(cp);
        setProfessor(p);
    }

    // string method
    public String toString() {
        return courseId + ": " + title + " (" + creditPoints + ")";
    }
}