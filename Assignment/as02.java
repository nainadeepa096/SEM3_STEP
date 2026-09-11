package Assignment;
import java.util.Scanner;

class as02{

    static void reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
             StringBuilder sb = new StringBuilder();

             for (int j = words[i].length() - 1; j >= 0; j--) {
                        sb.append(words[i].charAt(j));
                        
            }
            result += sb + " ";
        }

             
     

        System.out.println(result.trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();
        reverseWords(sentence);
    }
}

