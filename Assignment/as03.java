import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0; // ₹10 per hour
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹30 for first hour + ₹20 for each additional hour
        return 30.0 + (hours - 1) * 20.0;
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹50 per hour with minimum ₹100
        return Math.max(100.0, hours * 50.0);
    }
}

public class as03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = null;
            switch (type) {
                case "BIKE":
                    vehicle = new BikeVehicle(hours);
                    break;
                case "CAR":
                    vehicle = new CarVehicle(hours);
                    break;
                case "TRUCK":
                    vehicle = new TruckVehicle(hours);
                    break;
            }

            if (vehicle != null) {
                double charge = vehicle.calculateCharge();
                grandTotal += charge;
                System.out.printf("%s: %.2f\n", type, charge);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}