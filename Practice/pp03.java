import java.util.Random;

class pp03 {

    public static void main(String[] args) {

        Random r = new Random();

        int n = 10;

        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Generate random height and weight
        for (int i = 0; i < n; i++) {
            height[i] = 1.50 + r.nextDouble() * 0.50; // 1.50 to 2.00 m
            weight[i] = 45 + r.nextDouble() * 65;      // 45 to 110 kg

            // Calculate BMI
            bmi[i] = weight[i] / (height[i] * height[i]);

            // Classify BMI
            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 25)
                status[i] = "Normal";
            else if (bmi[i] < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

       
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }

        System.out.println("---------------------------------------------------------------");
    }
}