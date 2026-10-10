public class as04 {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            result.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}