package model;

public class Course {
	
	private static long idCounter = 100000;
    
    private long c_ID;
    private String title;
    private int creditPoints;
    private Professor professor;

    // No-argument constructor
	public Course() {
		this.c_ID = idCounter++;
		this.title = "Unknown course";
		this.creditPoints = 3;
		this.professor = new Professor();
	}

    // Argument constructor
	public Course(String title, int creditPoints, Professor professor) {
		this.c_ID = idCounter++;
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
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
	public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            this.title = "Unknown Course";
        }
    }
	
	public void setCreditPoints(int creditPoints) {
        if (creditPoints > 0 && creditPoints <= 30) {
            this.creditPoints = creditPoints;
        } else {
            this.creditPoints = 3;
        }
    }
	
	public void setProfessor(Professor professor) {
        if (professor != null) {
            this.professor = professor;
        } else {
            this.professor = new Professor();
        }
    }
	
    // toString method
	public String toString() {
        return "Course [c_ID=" + c_ID + ", title=" + title + ", creditPoints=" + creditPoints + 
               ", professor=" + professor.getName() + " " + professor.getSurname() + "]";
    }

}