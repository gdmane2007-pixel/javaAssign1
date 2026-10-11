import java.util.Scanner;

public class prime {

    public static void printPrimeFactorization(long number) {
        boolean firstFactor = true;   
        long factor = 2;

        System.out.print("Prime factorization: ");

      
        while (factor * factor <= number) {
            int count = 0;

            
            while (number % factor == 0) {
                count++;
                number = number / factor;
            }

            if (count > 0) {
                if (!firstFactor) {
                    System.out.print(" x ");
                }
                System.out.print(factor + "^" + count);
                firstFactor = false;
            }
            factor++;
        }

        
        if (number > 1) {
            if (!firstFactor) {
                System.out.print(" x ");
            }
            System.out.print(number + "^1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number: ");
        if (!sc.hasNextLong()) {
            System.out.println("Invalid input! Please enter a whole number.");
            return;
        }
        long number = sc.nextLong();

        if (number < 1) {
            System.out.println("Invalid input! Number must be 1 or greater.");
        } else if (number == 1) {
            System.out.println("1 has no prime factors (1 is neither prime nor composite).");
        } else {
            printPrimeFactorization(number);
        }
    }
}
