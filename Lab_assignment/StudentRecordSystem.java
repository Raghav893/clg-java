package Lab_assignment;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    protected String name;
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    public Student() {}

    public Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        setMarks(marks);
        determineGrade();
    }

    public void inputDetails(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks (0–100): ");
        marks = sc.nextDouble();

        while (marks < 0 || marks > 100) {
            System.out.print("Invalid input! Enter marks between 0–100: ");
            marks = sc.nextDouble();
        }

        determineGrade();
    }

    public void displayDetails() {
        System.out.println(this);
    }

    private void determineGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 50) grade = 'C';
        else grade = 'D';
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must range from 0 to 100.");
        }
        this.marks = marks;
        determineGrade();
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
                "\nName: " + name +
                "\nCourse: " + course +
                "\nMarks: " + marks +
                "\nGrade: " + grade;
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int option;

        do {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    Student st = new Student();
                    st.inputDetails(sc);
                    students.add(st);
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        for (Student student : students) {
                            student.displayDetails();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Closing application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 3);

        sc.close();
    }
}