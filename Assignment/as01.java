import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // ₹10 service charge
    }
}

public class as01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = null;
            switch (type) {
                case "STUDENT":
                    customer = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    customer = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    customer = new GuestCustomer(amount);
                    break;
            }

            if (customer != null) {
                double finalAmount = customer.calculateFinalAmount();
                grandTotal += finalAmount;
                System.out.printf("%s: %.2f\n", type, finalAmount);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}