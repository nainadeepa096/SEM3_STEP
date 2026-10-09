import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20.00;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getBasePrice();

    public double calculateAmount() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 150.00;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 250.00;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getBasePrice() {
        return 400.00;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket ticket = null;
            

            switch (type) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            if (ticket != null) {
                double amount = ticket.calculateAmount();
                total += amount;
                System.out.printf("%s: %.2f\n", type, amount);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}