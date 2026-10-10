import java.util.Arrays;

public class StudentMarks {
    private final String studentId;
    private final int[] marks;

    public StudentMarks(String studentId, int[] marks) {
        this.studentId = studentId;
        // Defensive copy on constructor input
        this.marks = (marks != null) ? Arrays.copyOf(marks, marks.length) : new int[0];
    }

    public String getStudentId() {
        return studentId;
    }

    // Returns a defensive copy to prevent modification of internal state
    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public double calculateAverage() {
        if (marks.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
}