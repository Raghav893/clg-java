import java.io.*;
import java.util.*;

public class StudentManager {

    private static final String FILE = "students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = FileUtil.loadStudents(FILE);

        System.out.println("Loaded " + list.size() + " students from file.");

        while (true) {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                list.add(new Student(roll, name, email, course, marks));
                System.out.println("Student Added!");

            } else if (ch == 2) {
                System.out.println("\n--- Student List ---");
                for (Student s : list) {
                    System.out.println(s);
                }

            } else if (ch == 3) {
                System.out.print("Enter name to search: ");
                String n = sc.nextLine();

                boolean found = false;
                for (Student s : list) {
                    if (s.name.equalsIgnoreCase(n)) {
                        System.out.println(s);
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("No student found.");

            } else if (ch == 4) {
                System.out.print("Enter name to delete: ");
                String del = sc.nextLine();

                list.removeIf(s -> s.name.equalsIgnoreCase(del));
                System.out.println("Record deleted if existed.");

            } else if (ch == 5) {
                list.sort(Comparator.comparingDouble(s -> s.marks));
                System.out.println("Sorted by Marks!");
                for (Student s : list) {
                    System.out.println(s);
                }

            } else if (ch == 6) {
                FileUtil.saveStudents(FILE, list);
                System.out.println("Data saved. Exiting...");
                break;
            }
        }
    }
}
