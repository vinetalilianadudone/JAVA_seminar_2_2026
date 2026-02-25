package model;

public class Grade {
	
	private static long idCounter = 200000;
    
    private long g_ID;
    private int value;
    private Student student;
    private Course course;

    // No-argument constructor
    public Grade() {
        this.g_ID = idCounter++;
        this.value = 4;
        this.student = new Student();
        this.course = new Course();
    }

    // Argument constructor
    public Grade(int value, Student student, Course course) {
        this.g_ID = idCounter++;
        setValue(value);
        setStudent(student);
        setCourse(course);
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
    public void setValue(int value) {
        if (value >= 1 && value <= 10) {
            this.value = value;
        } else {
            this.value = 4;
        }
    }

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            this.student = new Student();
        }
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        } else {
            this.course = new Course();
        }
    }

    // toString method
    public String toString() {
        return "Grade [g_ID=" + g_ID + ", value=" + value + 
               ", student=" + student.getName() + " " + student.getSurname() + 
               ", course=" + course.getTitle() + "]";
    }
}