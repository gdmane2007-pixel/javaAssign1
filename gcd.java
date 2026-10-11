import java.util.Scanner;

public class gcd {

    
    public static int calculateGcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    
    public static long calculateLcm(int a, int b) {
        int gcd = calculateGcd(a, b);       
        return (a / gcd) * (long) b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("First number: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter whole numbers only.");
            return;
        }
        int first = sc.nextInt();

        System.out.print("Second number: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter whole numbers only.");
            return;
        }
        int second = sc.nextInt();

        if (first <= 0 || second <= 0) {
            System.out.println("Invalid input! Both numbers must be positive.");
            return;
        }

        System.out.println("GCD: " + calculateGcd(first, second));
        System.out.println("LCM: " + calculateLcm(first, second));
    }
}
