package Assignments;
import java.util.Scanner;

class wk05 {

    static void classifyWords(String review) {

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        String[] words = review.split(" ");

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            }
            else if (length >= 5 && length <= 8) {
                mediumCount++;
            }
            else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("Long: " + longCount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie review:");
        String review = sc.nextLine();

        classifyWords(review);
        sc.close();
    }
}

