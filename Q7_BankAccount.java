import java.util.Scanner;

public class Q7_BankAccount {

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

        System.out.print("Account Holder: ");
        String holderName = sc.nextLine();

        int accountNumber = readInt(sc, "Account Number: ");
        while (accountNumber <= 0) {
            System.out.println("Account number must be positive. Try again.");
            accountNumber = readInt(sc, "Account Number: ");
        }

        double initialBalance = readDouble(sc, "Initial Balance: ");
        while (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Try again.");
            initialBalance = readDouble(sc, "Initial Balance: ");
        }

        double depositAmount = readDouble(sc, "Deposit: ");
        double withdrawAmount = readDouble(sc, "Withdrawal: ");

        BankAccount account = new BankAccount(holderName, accountNumber, initialBalance);

        System.out.println();
        account.displayAccountDetails();
        account.deposit(depositAmount);
        account.withdraw(withdrawAmount);
        account.displayBalance();
    }
}

class BankAccount {
    private String holderName;
    private int accountNumber;
    private double balance;

    // constructor: does not allow a negative starting balance
    public BankAccount(String holderName, int accountNumber, double initialBalance) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        if (initialBalance < 0) {
            System.out.println("Invalid initial balance! Starting with 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit Failed: amount must be greater than zero.");
        } else {
            balance = balance + amount;
            System.out.println("Deposit Successful");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal Failed: amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Withdrawal Failed: insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal Successful");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public void displayBalance() {
        System.out.printf("Final Balance: %.1f%n", balance);
    }
}
