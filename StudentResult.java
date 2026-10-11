import java.util.Scanner;

public class StudentResult {

    // Reads a whole number safely (keeps asking until a valid integer is typed)
    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();                  // clear the rest of the line
                return value;
            }
            System.out.println("Invalid input! Please enter a whole number.");
            sc.next();                          // throw away the wrong input
        }
    }

    // Keeps asking until the mark is between 0 and 100
    public static int readMark(Scanner sc, String subject) {
        int mark = readInt(sc, subject + " marks (0-100): ");
        while (!Student.isValidMark(mark)) {
            System.out.println("Marks must be between 0 and 100. Try again.");
            mark = readInt(sc, subject + " marks (0-100): ");
        }
        return mark;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        int rollNumber = readInt(sc, "Roll Number: ");
        while (rollNumber <= 0) {
            System.out.println("Roll number must be positive. Try again.");
            rollNumber = readInt(sc, "Roll Number: ");
        }

        int m1 = readMark(sc, "Subject 1");
        int m2 = readMark(sc, "Subject 2");
        int m3 = readMark(sc, "Subject 3");
        int m4 = readMark(sc, "Subject 4");
        int m5 = readMark(sc, "Subject 5");

        Student student = new Student(name, rollNumber, m1, m2, m3, m4, m5);

        System.out.println();
        student.displayResult();
    }
}

class Student {
    // private fields (encapsulation)
    private String name;
    private int rollNumber;
    private int mark1, mark2, mark3, mark4, mark5;

    // parameterized constructor
    public Student(String name, int rollNumber, int mark1, int mark2,
                   int mark3, int mark4, int mark5) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    // validation: a mark must be between 0 and 100
    public static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 100;
    }

    public int calculateTotal() {
        return mark1 + mark2 + mark3 + mark4 + mark5;
    }

    public double calculatePercentage() {
        return calculateTotal() / 5.0;      // 5 subjects, each out of 100
    }

    // PASS only if EVERY subject has at least 40 marks
    public String getResultStatus() {
        if (mark1 >= 40 && mark2 >= 40 && mark3 >= 40 && mark4 >= 40 && mark5 >= 40) {
            return "PASS";
        }
        return "FAIL";
    }

    public void displayResult() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + calculateTotal() + "/500");
        System.out.printf("Percentage: %.1f%%%n", calculatePercentage());
        System.out.println("Result: " + getResultStatus());
    }
}
