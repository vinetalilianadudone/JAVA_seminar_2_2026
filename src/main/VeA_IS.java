package main;

import java.util.*;
import model.*;

/* Lai izpildītu uzdevums, tika izmantota informācija par JAVA no: 
 * https://www.w3schools.com/java
 * moodle.venta.lv, kursa JAVA programmēšana, teorija
 * https://www.geeksforgeeks.org/java
 * https://www.w3schools.com/java/ref_arrays_sort.asp
 * https://prakashbtech87.medium.com/java-project-student-management-face85c55c3c
 * https://www.infoworld.com/article/2258024/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html
 */

public class VeA_IS {

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Professor> professors = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Grade> grades = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // studenti
            Student s1 = createStudent("Jānis","Bērziņš","010101-12345");
            Student s2 = createStudent("Anna","Kalniņa","020202-23456");
            Student s3 = createStudent("Pēteris","Ozols","030303-45678");

            // professori
            Professor p1 = createProfessor("Andris","Liepiņš","030303-34567", ProfessorDegree.phd);
            Professor p2 = createProfessor("Māris","Kļaviņš","040404-56789", ProfessorDegree.master);

            // kursi
            Course c1 = createCourse("Java", (byte)6, p1);
            Course c2 = createCourse("Matemātika", (byte)4, p1);
            Course c3 = createCourse("Fizika", (byte)5, p2);

            // atzīmes
            createGrade(8,s1,c1);
            createGrade(6,s1,c2);
            createGrade(7,s1,c3);

            createGrade(10,s2,c1);
            createGrade(9,s2,c3);

            createGrade(5,s3,c2);
            createGrade(6,s3,c3);

            // izvade
            System.out.println("STUDENTI");
            for(Student s : students) {
                printStudentFull(s);
            }

            System.out.println("\nPROFESORI");
            for(Professor p : professors) {
                printProfessorFull(p);
            }

            // sakārtošana
            sortStudents();
            System.out.println("\nSAKĀRTOTI STUDENTI PĒC ATZĪMĒM");
            for(Student s : students) {
                System.out.println(s + " | vidējā: " + avgGrade(s));
            }

        } catch(Exception e) {
            System.out.println("Kļūda: " + e.getMessage());
        }
    }

    // CRUD
    public static Student createStudent(String n,String s,String pc) throws Exception {
        Student st = new Student(n,s,pc);
        students.add(st);
        return st;
    }

    public static Student getStudent(long id) throws Exception {
        for(Student s:students) 
            if(s.getStudentId()==id) 
                return s;
        throw new Exception("Students neeksistē");
    }

    public static void updateStudent(long id,String n,String s) throws Exception {
        Student st = getStudent(id);
        st.setName(n);
        st.setSurname(s);
    }

    public static void deleteStudent(long id) throws Exception {
        students.remove(getStudent(id));
    }

    public static Professor createProfessor(String n,String s,String pc,ProfessorDegree d) {
        Professor p = new Professor(n,s,pc,d);
        professors.add(p);
        return p;
    }

    public static Course createCourse(String t,byte cp,Professor p) {
        Course c = new Course(t,cp,p);
        courses.add(c);
        return c;
    }

    public static Grade createGrade(int v,Student s,Course c) {
        Grade g = new Grade(v,s,c);
        grades.add(g);
        return g;
    }

    public static void deleteGrade(long id) throws Exception {
        Iterator<Grade> it = grades.iterator();
        while(it.hasNext()){
            Grade g = it.next();
            if(g.getGradeId() == id){
                it.remove();
                return;
            }
        }
        throw new Exception("Atzīme neeksistē");
    }

    public static void printStudentFull(Student s) {
        System.out.println(s);

        for(Grade g : grades) {
            if(g.getStudent().equals(s)) {
                System.out.println("  -> " + g.getCourse().getTitle() + ": " + g.getGradeValue());
            }
        }

        System.out.println("Vidējā: " + avgGrade(s));
        System.out.println("Svērtais: " + weightedAvg(s));
    }
    
    public static void printProfessorFull(Professor p) {
        System.out.println(p);

        for(Course c : courses) {
            if(c.getProfessor().equals(p)) {
                System.out.println("  -> māca: " + c.getTitle());
            }
        }

        System.out.println("Kursu skaits: " + countCourses(p));
    }
    
    // aprēķini
    public static double avgGrade(Student s) {
        double sum=0; 
        int count=0;
        for(Grade g:grades) 
            if(g.getStudent().equals(s)){ 
                sum += g.getGradeValue(); 
                count++; 
            }
        return count == 0 ? 0.0 : sum/count;
    }

    public static double weightedAvg(Student s) {
        double sum=0; double credits=0;
        for(Grade g:grades){
            if(g.getStudent().equals(s)){
                sum += g.getGradeValue()*g.getCourse().getCreditPoints();
                credits += g.getCourse().getCreditPoints();
            }
        }
        return credits == 0 ? 0.0 : sum/credits;
    }

    public static double avgCourse(Course c) {
        double sum = 0; 
        int count = 0;
        for(Grade g:grades) 
            if(g.getCourse().equals(c)){ 
                sum += g.getGradeValue(); 
                count++; 
            }
        return count == 0 ? 0.0 : sum/count;
    }

    public static int countCourses(Professor p) {
        int count=0;
        for(Course c:courses) 
            if(c.getProfessor().equals(p)) 
                count++;
        return count;
    }

    public static void sortStudents() {
        students.sort(Comparator.comparingDouble(VeA_IS::avgGrade).reversed());
    }
}