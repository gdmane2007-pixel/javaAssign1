import java.util.Scanner;

public class Q10_CompareEmployees {

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

    public static Employee readEmployee(Scanner sc, int number) {
        System.out.println("--- Employee " + number + " ---");

        System.out.print("Name: ");
        String name = sc.nextLine();

        int id = readInt(sc, "Employee ID: ");
        while (id <= 0) {
            System.out.println("Employee ID must be positive. Try again.");
            id = readInt(sc, "Employee ID: ");
        }

        double salary = readDouble(sc, "Monthly Salary: ");
        while (salary < 0) {
            System.out.println("Salary cannot be negative. Try again.");
            salary = readDouble(sc, "Monthly Salary: ");
        }

        return new Employee(name, id, salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee emp1 = readEmployee(sc, 1);
        Employee emp2 = readEmployee(sc, 2);
        Employee emp3 = readEmployee(sc, 3);

        System.out.println();

        
        emp1.compareSalary(emp2);
        emp2.compareSalary(emp3);

      
        Employee highest = emp1.getHigherPaid(emp2);
        highest = highest.getHigherPaid(emp3);

        System.out.println("Highest-paid employee: " + highest.getName());
        System.out.printf("Annual Salary: %.1f%n", highest.calculateAnnualSalary());
    }
}

class Employee {
    private String name;
    private int employeeId;
    private double monthlySalary;

    public Employee(String name, int employeeId, double monthlySalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

   
    public void compareSalary(Employee other) {
        double mySalary = this.calculateAnnualSalary();
        double otherSalary = other.calculateAnnualSalary();

        if (mySalary > otherSalary) {
            System.out.println(this.name + " earns more than " + other.name + ".");
        } else if (mySalary < otherSalary) {
            System.out.println(other.name + " earns more than " + this.name + ".");
        } else {
            System.out.println(this.name + " and " + other.name + " have equal annual salaries.");
        }
    }

    
    public Employee getHigherPaid(Employee other) {
        if (other.calculateAnnualSalary() > this.calculateAnnualSalary()) {
            return other;
        }
        return this;
    }
}
