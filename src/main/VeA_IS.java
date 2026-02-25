package main;

import model.Professor;
import model.Student;
import model.Course;
import model.Grade;
import java.util.ArrayList;

public class VeA_IS {
	
	// Saraksti profesoriem, studentiem, kursiem un atzīmēm
	public static ArrayList<Professor> profLists = new ArrayList<>();
	public static ArrayList<Student> studentLists = new ArrayList<>();
	public static ArrayList<Course> courseLists = new ArrayList<>();
	public static ArrayList<Grade> gradeLists = new ArrayList<>();
	    
	public static void main(String[] args) {

	Professor prof1 = new Professor("Artūrs", "Smits", "PhD");
    Professor prof2 = new Professor("Anna", "Johnson", "Dr");
    Professor prof3 = new Professor(); 

    // Pievieno sarakstam
    profLists.add(prof1);
    profLists.add(prof2);
    profLists.add(prof3);
        
    Student stud1 = new Student("Pēteris", "Parkeris", "123456-78901");
    Student stud2 = new Student("Marta", "Dzelme", "109876-54321");
    Student stud3 = new Student("Vineta Liliana", "Dudone", "160504-21644");
    Student stud4 = new Student(); 
        
    studentLists.add(stud1);
    studentLists.add(stud2);
    studentLists.add(stud3);
    studentLists.add(stud4);
        
    Course course1 = new Course("Java Programming", 6, prof1);
    Course course2 = new Course("Database Systems", 4, prof1);
    Course course3 = new Course("Web Development", 3, prof2);
    Course course4 = new Course();
        
    courseLists.add(course1);
    courseLists.add(course2);
    courseLists.add(course3);
    courseLists.add(course4);
        
    Grade grade1 = new Grade(9, stud1, course1);
    Grade grade2 = new Grade(8, stud1, course2);
    Grade grade3 = new Grade(7, stud1, course3);
    Grade grade4 = new Grade(10, stud2, course1);
    Grade grade5 = new Grade(6, stud2, course2);
    Grade grade6 = new Grade(5, stud3, course3);
    Grade grade7 = new Grade(4, stud3, course1);
    Grade grade8 = new Grade();
        
    gradeLists.add(grade1);
    gradeLists.add(grade2);
    gradeLists.add(grade3);
    gradeLists.add(grade4);
    gradeLists.add(grade5);
    gradeLists.add(grade6);
    gradeLists.add(grade7);
    gradeLists.add(grade8);
        
    // Izvade konsolē
    System.out.println("------ PROFESSORS ------");
    for (Professor p : profLists) {
        System.out.println(p);
    }
    
    System.out.println("\n------STUDENTS ------");
    for (Student s : studentLists) {
        System.out.println(s);
    }
    
    System.out.println("\n------ COURSES ------");
    for (Course c : courseLists) {
        System.out.println(c);
    }
    
    System.out.println("\n------ GRADES ------");
    for (Grade g : gradeLists) {
        System.out.println(g);
    }
    
    }
}