import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class as05 implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    // Overloaded eligibility check 1: CGPA-only filter (e.g., CGPA >= 8.0)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    // Overloaded eligibility check 2: Borderline CGPA + coding test filter (e.g., CGPA >= 6.5 AND Coding >= 75)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 75;
    }

    // Descending order sort by composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static Candidate[] shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] result = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(result); // Uses Candidate's compareTo implementation
        
        return result;
    }
}