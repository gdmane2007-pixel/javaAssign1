import java.util.Scanner;

public class strongNo {

    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 2; i <= digit; i++) {
            fact = fact * i;
        }
        return fact;
    }

    
    public static boolean isStrong(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;         
            sum = sum + factorial(digit);   
            temp = temp / 10;               
        }
        return sum == number;               
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a positive integer.");
            return;
        }
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input! Number must be positive.");
            return;
        }

        if (isStrong(number)) {
            System.out.println(number + " is a Strong Number.");
        } else {
            System.out.println(number + " is not a Strong Number.");
        }
    }
}
