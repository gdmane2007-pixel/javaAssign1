import java.util.Scanner;

public class Q9_ProductBilling {

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

        System.out.print("Product: ");
        String name = sc.nextLine();

        int productId = readInt(sc, "Product ID: ");
        while (productId <= 0) {
            System.out.println("Product ID must be positive. Try again.");
            productId = readInt(sc, "Product ID: ");
        }

        double unitPrice = readDouble(sc, "Unit Price: ");
        while (!Product.isValidPrice(unitPrice)) {
            System.out.println("Price must be greater than zero. Try again.");
            unitPrice = readDouble(sc, "Unit Price: ");
        }

        int quantity = readInt(sc, "Quantity: ");
        while (!Product.isValidQuantity(quantity)) {
            System.out.println("Quantity must be at least 1. Try again.");
            quantity = readInt(sc, "Quantity: ");
        }

        Product product = new Product(name, productId, unitPrice, quantity);

        System.out.println();
        product.displayBill();
    }
}

class Product {
    private String name;
    private int productId;
    private double unitPrice;
    private int quantity;

    public Product(String name, int productId, double unitPrice, int quantity) {
        this.name = name;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // validation helpers
    public static boolean isValidPrice(double price) {
        return price > 0;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public double calculateSubtotal() {
        return unitPrice * quantity;
    }

    // discount percentage based on subtotal slabs
    public int getDiscountPercentage(double subtotal) {
        if (subtotal < 1000) {
            return 0;
        } else if (subtotal < 5000) {
            return 5;
        } else if (subtotal < 10000) {
            return 10;
        } else {
            return 15;
        }
    }

    public double calculateDiscount() {
        double subtotal = calculateSubtotal();
        return subtotal * getDiscountPercentage(subtotal) / 100;
    }

    public double calculateFinalBill() {
        return calculateSubtotal() - calculateDiscount();
    }

    public void displayBill() {
        System.out.println("Product Name: " + name);
        System.out.println("Product ID: " + productId);
        System.out.printf("Subtotal: %.1f%n", calculateSubtotal());
        System.out.printf("Discount: %.1f%n", calculateDiscount());
        System.out.printf("Final Bill: %.1f%n", calculateFinalBill());
    }
}
