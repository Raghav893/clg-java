import java.util.Scanner;
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (double) a / b;
    }
}

public class CalculatorApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();
    public void performAddition() {
        System.out.println("Choose addition type: 1. Two integers 2. Two doubles 3. Three integers");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter two integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Result: " + calculator.add(a, b));
            }
            case 2 -> {
                System.out.print("Enter two doubles: ");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                System.out.println("Result: " + calculator.add(a, b));
            }
            case 3 -> {
                System.out.print("Enter three integers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                System.out.println("Result: " + calculator.add(a, b, c));
            }
            default -> System.out.println("Invalid choice.");
        }
    }
    public void performSubtraction() {
        System.out.print("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Result: " + calculator.subtract(a, b));
    }
    public void performMultiplication() {
        System.out.print("Enter two doubles: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("Result: " + calculator.multiply(a, b));
    }
    public void performDivision() {
        System.out.print("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        try {
            System.out.println("Result: " + calculator.divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public void mainMenu() {
        while (true) {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.mainMenu();
    }
}