package Assignments;
import java.util.Scanner;
public class wk03 {
    static void findLongestStreak(String signalLog) {
        int current = 1;
        int longest = 1;
        char longestColor = signalLog.charAt(0);

         for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }

            if (current > longest){
                longest = current;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Color: " + longestColor);
        System.out.println("Length: " + longest);
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);
    }





    
}
