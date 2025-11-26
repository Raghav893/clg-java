import java.util.*;

abstract class Person {
    protected String name;
    protected String email;

    public Person() {}
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public abstract void showInfo();
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    public Student() {}

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        assignGrade();
    }

    public Student(int i, String ankit, String mail) {


    }

    @Override
    public void showInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------");
    }

    public void showInfo(boolean shortView) {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        if (shortView) System.out.println("(Short View)");
        System.out.println("-------------------");
    }

    private void assignGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 60) grade = 'C';
        else grade = 'D';
    }

    public int getRollNo() {
        return rollNo;
    }
}

interface RecordActions {
    void addStudent() throws StudentNotFoundException;

    void addStudent(Student s);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, Student newData);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

class StudentManager implements RecordActions {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getRollNo())) {
            System.out.println("Roll no already exists");
            return;
        }
        studentMap.put(s.getRollNo(), s);
        System.out.println("Student added");
    }

    public void deleteStudent(int rollNo) {
        if (studentMap.remove(rollNo) != null)
            System.out.println("Deleted");
        else
            System.out.println("Not found");
    }

    public void updateStudent(int rollNo, Student newData) {
        if (studentMap.containsKey(rollNo)) {
            studentMap.put(rollNo, newData);
            System.out.println("Updated");
        } else {
            System.out.println("Not found");
        }
    }

    public Student searchStudent(int rollNo) {
        return studentMap.get(rollNo);
    }

    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No records");
            return;
        }
        for (Student s : studentMap.values()) {
            s.showInfo();
        }
    }
}

public class Lab2 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student s1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech", 87);
        Student s2 = new Student(102, "Riya", "riya@mail.com", "M.Tech", 92);

        manager.addStudent(s1);
        manager.addStudent(s2);

        manager.viewAllStudents();

        s1.showInfo(true);

        System.out.println("Searching roll no 101:");
        Student found = manager.searchStudent(101);
        if (found != null) found.showInfo();

        Student updated = new Student(101, "Ankit", "ankit@mail.com");
    }
}