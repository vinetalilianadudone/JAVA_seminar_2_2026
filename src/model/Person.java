package model;

public class Person {

    protected String name;
    protected String surname;

    // No-argument constructor
    public Person() {
        this.name = "Unknown";
        this.surname = "Unknown";
    }

    // Argument constructor
    public Person(String inputName, String inputSurname) {
        setName(inputName);
        setSurname(inputSurname);
    }

    // Get method
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // Set method
    public void setName(String inputName) {
        if (inputName != null && inputName.matches("^[\\p{L}][\\p{L}\\s\\-']+$"))
            this.name = inputName;
        else
            this.name = "Unknown";
    }

    public void setSurname(String inputSurname) {
        if (inputSurname != null && inputSurname.matches("^[\\p{L}][\\p{L}\\s\\-']+$"))
            this.surname = inputSurname;
        else
            this.surname = "Unknown";
    }

    // toString method
    public String toString() {
        return name + " " + surname;
    }
}