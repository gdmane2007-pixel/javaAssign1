import java.util.Scanner;

public class armStrong {

   
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    
    public static long power(int base, int exponent) {
        long result = 1;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    
    public static boolean isArmstrong(int number) {
        int digits = countDigits(number);
        long sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + power(digit, digits);  
            temp = temp / 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Start: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter whole numbers only.");
            return;
        }
        int start = sc.nextInt();

        System.out.print("End: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter whole numbers only.");
            return;
        }
        int end = sc.nextInt();

        if (start <= 0 || end <= 0) {
            System.out.println("Invalid input! Both numbers must be positive.");
            return;
        }
        if (start > end) {
            System.out.println("Invalid range! Start must not be greater than End.");
            return;
        }

        boolean found = false;
        System.out.print("Armstrong numbers:");
        for (int i = start; i <= end; i++) {
            if (isArmstrong(i)) {
                System.out.print(" " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.print(" None found in this range");
        }
        System.out.println();
    }
}
