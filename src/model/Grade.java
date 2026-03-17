package model;

public class Grade {

	// variables
    private long gradeId;
    private int gradeValue;
    private Student student;
    private Course course;
    private static long counter = 200000;

    // get and set methods
    public long getGradeId() {
    	return gradeId; 
    	}
    
    public int getGradeValue() { 
    	return gradeValue; 
    	}
    
    public Student getStudent() { 
    	return student; 
    	}
    
    public Course getCourse() { 
    	return course; 
    	}

    private void generateId() {
        gradeId = counter++;
    }

    public void setGradeValue(int value) {
        if (value >= 1 && value <= 10) 
        	gradeValue = value;
        else 
        	throw new IllegalArgumentException("Nepareiza atzīme");
    }

    public void setStudent(Student stud) {
        if (stud != null) 
        	student = stud;
        else 
        	throw new IllegalArgumentException("Students nevar būt null");
    }

    public void setCourse(Course c) {
        if (c != null) 
        	course = c;
        else 
        	throw new IllegalArgumentException("Kurss nevar būt null");
    }

    // no-argument constructor
    public Grade() {
        this(1, new Student(), new Course());
    }
 
    // argument constructor
    public Grade(int value, Student stud, Course c) {
        generateId();
        setGradeValue(value);
        setStudent(stud);
        setCourse(c);
    }

    // to string method
    public String toString() {
        return gradeId + ": " + student.getSurname() + " -> " + gradeValue + " (" + course.getTitle() + ")";
    }
}