package Practice;
import java.util.Scanner;

abstract class Connection {
    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }
}

public class pp04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection conn = null;

            switch (type) {
                case "HOME":
                    conn = new HomeConnection(units);
                    break;
                case "SHOP":
                    conn = new ShopConnection(units);
                    break;
                case "FACTORY":
                    conn = new FactoryConnection(units);
                    break;
            }

            if (conn != null) {
                double bill = conn.calculateBill();
                total += bill;
                System.out.printf("%s: %.2f\n", type, bill);
            }
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}