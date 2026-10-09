import java.util.Scanner;

interface SaverModeCapable {
    double applySaverDiscount(double units);
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRatingWatts();

    public double calculateBaseUnits() {
        return (getPowerRatingWatts() * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }
    @Override public double getPowerRatingWatts() { return 150.0; }
}

class TV extends Appliance {
    public TV(double hours) { super(hours); }
    @Override public double getPowerRatingWatts() { return 100.0; }
}

class AC extends Appliance implements SaverModeCapable {
    public AC(double hours) { super(hours); }
    @Override public double getPowerRatingWatts() { return 1500.0; }
    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

class Washer extends Appliance implements SaverModeCapable {
    public Washer(double hours) { super(hours); }
    @Override public double getPowerRatingWatts() { return 500.0; }
    @Override
    public double applySaverDiscount(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        sc.nextLine(); 
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");

            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaver = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            Appliance app = null;
            switch (type) {
                case "FRIDGE": app = new Fridge(hours); break;
                case "AC": app = new AC(hours); break;
                case "TV": app = new TV(hours); break;
                case "WASHER": app = new Washer(hours); break;
            }

            if (app != null) {
                if (isSaver && !(app instanceof SaverModeCapable)) {
                    System.out.printf("%s: saver mode not supported\n", type);
                } else {
                    double units = app.calculateBaseUnits();
                    if (isSaver) {
                        units = ((SaverModeCapable) app).applySaverDiscount(units);
                    }
                    double cost = app.calculateCost(units);
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}