import java.util.Scanner;

public class secondLargest{

    
    public static int findSecondLargestDigit(long number) {
        int largest = -1;  
        int second = -1;

        while (number > 0) {
            int digit = (int) (number % 10);   // take the last digit

            if (digit > largest) {
                second = largest;              // old largest becomes second largest
                largest = digit;               // new largest
            } else if (digit < largest && digit > second) {
                second = digit;                // digit fits between largest and second
            }
            // if digit == largest 

            number = number / 10;              // remove the last digit
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number: ");
        if (!sc.hasNextLong()) {
            System.out.println("Invalid input! Please enter a positive integer.");
            return;
        }
        long number = sc.nextLong();

        if (number <= 0) {
            System.out.println("Invalid input! Number must be positive.");
            return;
        }

        int result = findSecondLargestDigit(number);

        if (result == -1) {
            System.out.println("The number has fewer than two distinct digits, so there is no second-largest digit.");
        } else {
            System.out.println("Second-largest distinct digit: " + result);
        }
    }
}
