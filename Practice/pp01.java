import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount; // No fee
    }
}

public class pp01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = null;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;
                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment(amount);
                    break;
            }

            if (payment != null) {
                double finalAmount = payment.calculateFinalAmount();
                grandTotal += finalAmount;
                System.out.printf("%s: %.2f\n", type, finalAmount);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}