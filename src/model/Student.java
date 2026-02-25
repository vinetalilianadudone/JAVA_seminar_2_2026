package model;

public class Student {

private static long idCounter = 0;
    
    private long p_ID;
    private String name;
    private String surname;

	public Student() {
		this.p_ID = idCounter++;
        this.name = "Unknown";
        this.surname = "Unknown";
	}
	
	public Student(String name, String surname) {
        this.p_ID = idCounter++;
        setName(name);
        setSurname(surname);
    }
	
	public long getProfID() {
        return p_ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty() && name.matches("[a-zA-ZāčēģīķļņōŗšūžĀČĒĢĪĶĻŅŌŖŠŪŽ\\s]+")) {
            this.name = name;
        } else {
            System.out.println("Invalid name! Using default.");
            this.name = "Unknown";
        }
    }
    
    public void setSurname(String surname) {
        if (surname != null && !surname.trim().isEmpty() && surname.matches("[a-zA-ZāčēģīķļņōŗšūžĀČĒĢĪĶĻŅŌŖŠŪŽ\\s]+")) {
            this.surname = surname;
        } else {
            System.out.println("Invalid surname! Using default.");
            this.surname = "Unknown";
        }
    }

    public String toString() {
        return "Professor [p_ID=" + p_ID + ", name=" + name + ", surname=" + surname + "]";
    }
}