import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class pp05 implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    // Overloaded rule 1: Established players clear on experience alone (e.g., 10+ matches)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Newer players clear on moderate experience and non-injured status
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Comparable implementation to sort descending by fantasy points (batting average)
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            // Check established rule OR newer player rule
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);

        // Standard library sort using compareTo
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}