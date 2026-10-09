import java.util.Scanner;

abstract class Vehicle {
    protected int days;

    public Vehicle(int days) {
        this.days = days;
    }

    public abstract double calculateRent();
}

class CarRental extends Vehicle {
    public CarRental(int days) {
        super(days);
    }

    @Override
    public double calculateRent() {
        return days * 1000.0;
    }
}

class BikeRental extends Vehicle {
    public BikeRental(int days) {
        super(days);
    }

    @Override
    public double calculateRent() {
        return days * 300.0;
    }
}

class LuxuryCarRental extends Vehicle {
    public LuxuryCarRental(int days) {
        super(days);
    }

    @Override
    public double calculateRent() {
        return (days * 2500.0) + 500.0;
    }
}

public class as05{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalRent = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int days = sc.nextInt();

            Vehicle vehicle = null;
            switch (type) {
                case "CAR":
                    vehicle = new CarRental(days);
                    break;
                case "BIKE":
                    vehicle = new BikeRental(days);
                    break;
                case "LUXURYCAR":
                    vehicle = new LuxuryCarRental(days);
                    break;
            }

            if (vehicle != null) {
                double rent = vehicle.calculateRent();
                totalRent += rent;
                System.out.printf("%s: %.2f\n", type, rent);
            }
        }

        System.out.printf("Total Rent: %.2f\n", totalRent);
        sc.close();
    }
}