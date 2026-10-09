import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class pp05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport = null;

            if (type.equals("BUS")) {
                transport = new BusTransport(distance);
            } else if (type.equals("TRAIN")) {
                transport = new TrainTransport(distance);
            } else if (type.equals("METRO")) {
                double peakHourFactor = sc.nextDouble();
                transport = new MetroTransport(distance, peakHourFactor);
            }

            if (transport != null) {
                double fare = transport.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f\n", type, fare);
            }
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}