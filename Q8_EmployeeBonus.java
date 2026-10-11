import java.util.Scanner;

public class Q8_EmployeeBonus {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Invalid input! Please enter a whole number.");
            sc.next();
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        int employeeId = readInt(sc, "Employee ID: ");
        while (employeeId <= 0) {
            System.out.println("Employee ID must be positive. Try again.");
            employeeId = readInt(sc, "Employee ID: ");
        }

        double monthlySalary = readDouble(sc, "Monthly Salary: ");
        while (!Employee.isValidSalary(monthlySalary)) {
            System.out.println("Salary cannot be negative. Try again.");
            monthlySalary = readDouble(sc, "Monthly Salary: ");
        }

        int rating = readInt(sc, "Performance Rating (1-5): ");
        while (!Employee.isValidRating(rating)) {
            System.out.println("Rating must be between 1 and 5. Try again.");
            rating = readInt(sc, "Performance Rating (1-5): ");
        }

        Employee employee = new Employee(name, employeeId, monthlySalary, rating);

        System.out.println();
        employee.displaySalaryDetails();
    }
}

class Employee {
    private String name;
    private int employeeId;
    private double monthlySalary;
    private int rating;

    public Employee(String name, int employeeId, double monthlySalary, int rating) {
        this.name = name;
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
        this.rating = rating;
    }

    // validation helpers
    public static boolean isValidSalary(double salary) {
        return salary >= 0;
    }

    public static boolean isValidRating(int rating) {
        return rating >= 1 && rating <= 5;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    // bonus percentage depends on the rating
    public int getBonusPercentage() {
        if (rating == 5) {
            return 20;
        } else if (rating == 4) {
            return 15;
        } else if (rating == 3) {
            return 10;
        } else if (rating == 2) {
            return 5;
        } else {
            return 0;       // rating 1
        }
    }

    public double calculateBonus() {
        return calculateAnnualSalary() * getBonusPercentage() / 100;
    }

    public void displaySalaryDetails() {
        double annual = calculateAnnualSalary();
        double bonus = calculateBonus();

        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.printf("Monthly Salary: %.1f%n", monthlySalary);
        System.out.printf("Annual Salary: %.1f%n", annual);
        System.out.printf("Annual Bonus: %.1f%n", bonus);
        System.out.printf("Total Annual Compensation: %.1f%n", annual + bonus);
    }
}
