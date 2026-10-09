import java.util.Scanner;

interface NightServiceable {
    double applyNightMultiplier(double baseFare);
}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        double fare = km * getRatePerKm();
        return Math.max(fare, 100.00);
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightMultiplier(double baseFare) {
        return baseFare * 1.20;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightMultiplier(double baseFare) {
        return baseFare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            if (cabType.equals("MINI")) cab = new MiniCab(km);
            else if (cabType.equals("SEDAN")) cab = new SedanCab(km);
            else if (cabType.equals("SUV")) cab = new SUVCab(km);

            if (cab != null) {
                if (time.equals("NIGHT") && !(cab instanceof NightServiceable)) {
                    System.out.printf("%s: night service not available\n", cabType);
                } else {
                    double fare = cab.calculateBaseFare();
                    if (time.equals("NIGHT")) {
                        fare = ((NightServiceable) cab).applyNightMultiplier(fare);
                    }
                    total += fare;
                    System.out.printf("%s: %.2f\n", cabType, fare);
                }
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}