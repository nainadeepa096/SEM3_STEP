import java.util.Scanner;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected int points;

    public Question(String text, String correctAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public abstract double evaluate(String studentAnswer);
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String text, String correctAnswer, int points) {
        super(text, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String correctAnswer, int points) {
        super(text, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, int points) {
        super(text, correctAnswer, points);
    }

    @Override
    public double evaluate(String studentAnswer) {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            if (lowerStudentAns.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class pp04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // Consume remaining newline

        double totalScore = 0.0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            // Extract tokens wrapped in quotes or space-separated
            java.util.List<String> tokens = new java.util.ArrayList<>();
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            if (tokens.size() < 5) continue;

            String type = tokens.get(0);
            String text = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            int points = Integer.parseInt(tokens.get(4));

            Question q = null;
            switch (type) {
                case "MCQ":
                    q = new MultipleChoiceQuestion(text, correctAnswer, points);
                    break;
                case "TF":
                    q = new TrueFalseQuestion(text, correctAnswer, points);
                    break;
                case "ESSAY":
                    q = new EssayQuestion(text, correctAnswer, points);
                    break;
            }

            if (q != null) {
                double score = q.evaluate(studentAnswer);
                totalScore += score;
                System.out.printf("%s: %.2f\n", type, score);
            }
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        sc.close();
    }
}