package model;

public abstract class Person {

	// variables
    private String name;
    private String surname;
    private String personCode;

    // get and set methods
    public String getName() { 
    	return name; 
    	}
    
    public String getSurname() { 
    	return surname; 
    	}
    
    public String getPersonCode() { 
    	return personCode; 
    	}

    public void setName(String inputName) {
        if ((inputName != null) && (!inputName.isEmpty()) &&
        		(inputName.matches("[A-ZĀČĒĢĪĶĻŅŌŖŠŪŽ]{1}[a-zāčēģīķļņōŗšūž]{2,15}([ ]{1}[A-ZĀČĒĢĪĶĻŅŌŖŠŪŽ]{1}[a-zāčēģīķļņōŗšūž]{2,15})?"))) {
            name = inputName;
        } else {
            throw new IllegalArgumentException("Nepareizs vārds");
        }
    }

    public void setSurname(String inputSurname) {
        if ((inputSurname != null) && (!inputSurname.isEmpty()) &&
        		(inputSurname.matches("[A-ZĀČĒĢĪĶĻŅŌŖŠŪŽ]{1}[a-zāčēģīķļņōŗšūž]{2,15}([-]{1}[A-ZĀČĒĢĪĶĻŅŌŖŠŪŽ]{1}[a-zāčēģīķļņōŗšūž]{2,15})?"))) {
            surname = inputSurname;
        } else {
            throw new IllegalArgumentException("Nepareizs uzvārds");
        }
    }

    public void setPersonCode(String inputPersonCode) {
        if ((inputPersonCode != null) && (inputPersonCode.matches("[0-9]{6}[-]{1}[0-9]{5}"))) {
            personCode = inputPersonCode;
        } else {
            throw new IllegalArgumentException("Nepareizs personas kods");
        }
    }

    // no-argument constructor
    public Person() {
        this("Līga","Jauka","090923-12345");
    }
    
    // argument constructor
    public Person(String n, String s, String pc) {
        setName(n);
        setSurname(s);
        setPersonCode(pc);
    }

    // to string method
    public String toString() {
        return name + " " + surname + " (" + personCode + ")";
    }
}