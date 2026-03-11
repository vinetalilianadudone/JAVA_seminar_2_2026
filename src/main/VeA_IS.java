package main;

import model.*;
import java.util.ArrayList;
import java.util.Comparator;

/* Lai izpildītu uzdevums, tika izmantota informācija par JAVA no: 
 * https://www.w3schools.com/java
 * moodle.venta.lv, kursa JAVA programmēšana, teorija
 * https://www.geeksforgeeks.org/java
 * https://prakashbtech87.medium.com/java-project-student-management-face85c55c3c
 * https://www.infoworld.com/article/2258024/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html
 */

public class VeA_IS {

	// Statisks saraksts
    public static ArrayList<Professor> profLists = new ArrayList<>();
    public static ArrayList<Student> studentLists = new ArrayList<>();
    public static ArrayList<Course> courseLists = new ArrayList<>();
    public static ArrayList<Grade> gradeLists = new ArrayList<>();

    public static void main(String[] args) {

        // Izveido trīs profesoru objektus - divus ar datiem un vienu ar noklusējuma vērtībām
        Professor prof1 = new Professor("Artūrs", "Smits", "PhD");
        Professor prof2 = new Professor("Anna", "Johnson", "Dr");
        Professor prof3 = new Professor();

        // Pievieno profesorus kopīgajam sarakstam
        profLists.add(prof1);
        profLists.add(prof2);
        profLists.add(prof3);

        // Izveido četrus studentu objektus - trīs ar datiem un vienu ar noklusējuma vērtībām
        Student stud1 = new Student("Pēteris", "Parkeris", "123456-78901");
        Student stud2 = new Student("Marta", "Dzelme", "109876-54321");
        Student stud3 = new Student("Vineta Liliana", "Dudone", "160504-12456");
        Student stud4 = new Student();

        // Pievieno studentus kopīgajam sarakstam
        studentLists.add(stud1);
        studentLists.add(stud2);
        studentLists.add(stud3);
        studentLists.add(stud4);

        // Izveido četrus kursu objektus - trīs ar datiem un vienu ar noklusējuma vērtībām
        Course course1 = new Course("Java Programming", 6, prof1);
        Course course2 = new Course("Database Systems", 4, prof1);
        Course course3 = new Course("Web Development", 3, prof2);
        Course course4 = new Course();

        // Pievieno kursus kopīgajam sarakstam
        courseLists.add(course1);
        courseLists.add(course2);
        courseLists.add(course3);
        courseLists.add(course4);

        // Izveido atzīmes un pievieno tās sarakstam 
        gradeLists.add(new Grade(9, stud1, course1));
        gradeLists.add(new Grade(8, stud1, course2));
        gradeLists.add(new Grade(7, stud1, course3));
        gradeLists.add(new Grade(10, stud2, course1));
        gradeLists.add(new Grade(6, stud2, course2));
        gradeLists.add(new Grade(5, stud3, course3));
        gradeLists.add(new Grade(4, stud3, course1));
        gradeLists.add(new Grade());

        System.out.println("\n--- Average grade per student ---");
        for (Student s : studentLists) {
            System.out.println(s + " | Avg grade: " + calcAvgGrade(s));
            System.out.println("Weighted Avg grade: " + calcWeightedAvgGrade(s));
        }

        System.out.println("\n--- Average grade per course ---");
        for (Course c : courseLists) {
            System.out.println(c + " | Avg grade: " + calcAvgGradeForCourse(c));
        }

        System.out.println("\n--- Professor course count ---");
        for (Professor p : profLists) {
            System.out.println(p + " | Courses taught: " + countCoursesForProfessor(p));
        }

        System.out.println("\n--- Students sorted by average grade ---");
        studentLists.sort(Comparator.comparingDouble(VeA_IS::calcAvgGrade).reversed());
        for (Student s : studentLists) {
            System.out.println(s + " | Avg grade: " + calcAvgGrade(s));
        }

        System.out.println("\n--- Mixed Person list (Polymorphism) ---");
        ArrayList<Person> mixed = new ArrayList<>();
        mixed.addAll(studentLists);
        mixed.addAll(profLists);
        for (Person p : mixed) {
            System.out.println(p);
        }
    }

    // Vidēja atzīme studentam
    public static double calcAvgGrade(Student s) {
        int sum = 0;
        int count = 0;
        for (Grade g : gradeLists) {
            if (g.getStudent() == s) {
                sum += g.getValue();
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    // Vidēja atzīme ar kredītpunktiem 
    public static double calcWeightedAvgGrade(Student s) {
        int totalPoints = 0;
        int totalCredits = 0;
        for (Grade g : gradeLists) {
            if (g.getStudent() == s) {
                int credits = g.getCourse().getCreditPoints();
                totalPoints += g.getValue() * credits;
                totalCredits += credits;
            }
        }
        return totalCredits == 0 ? 0 : (double) totalPoints / totalCredits;
    }

    // Vidēja atzīme kursam
    public static double calcAvgGradeForCourse(Course c) {
        int sum = 0;
        int count = 0;
        for (Grade g : gradeLists) {
            if (g.getCourse() == c) {
                sum += g.getValue();
                count++;
            }
        }
        // Atgriež 0, citādi aprēķina vidējo
        return count == 0 ? 0 : (double) sum / count;
    }

    // Kursu skaits professoram
    public static int countCoursesForProfessor(Professor p) {
        int count = 0;
        for (Course c : courseLists) {
            if (c.getProfessor() == p) { 
            	count++;
            }
        }
        return count;
    }
}