import java.util.Scanner;

abstract class Room {
    protected double units;

    public Room(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // ₹8 per unit
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        // ₹6 per unit, divided equally among occupants
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // ₹10 per unit + fixed ₹200
        return (units * 10.0) + 200.0;
    }
}

public class as02{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Room room = null;
            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                room = new ACRoom(units);
            }

            if (room != null) {
                double bill = room.calculateBill();
                grandTotal += bill;
                System.out.printf("%s: %.2f\n", type, bill);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}