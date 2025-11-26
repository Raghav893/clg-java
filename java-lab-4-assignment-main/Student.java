public class Student {
    int roll;
    String name, email, course;
    double marks;

    public Student(int roll, String name, String email, String course, double marks) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + email + "," + course + "," + marks;
    }
}
