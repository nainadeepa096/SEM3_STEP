package Practice;
import java.util.Scanner;
public class qs05 {
    static void validateReference(String ref) {
        ref = ref.trim();
        if(ref.length()>=3){
            ref = ref.substring(0,3).toUpperCase() + ref.substring(3);
        }
         if (ref.length() != 14) {
            System.out.println("Wrong length");
            return;
        }
         for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                System.out.println("Non-letter bank code");
                return;
            }
        }
         for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                System.out.println("Non-digit body");
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(ref.substring(0, 3)).append("] DATE: ")
          .append(ref.substring(3, 5)).append("/")
          .append(ref.substring(5, 7)).append("/")
          .append(ref.substring(7, 9)).append(" | SEQ: ")
          .append(ref.substring(9));

        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validateReference(sc.nextLine());
    }


    
}
