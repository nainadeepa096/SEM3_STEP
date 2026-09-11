package Assignment;
import java.util.Scanner;

class as04 {

    static void validate(String code) {
        code = code.trim();

        if (code.length() >= 3)
            code = code.substring(0, 3).toUpperCase() + code.substring(3);

        if (code.length() != 13) {
            System.out.println("Wrong length");
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Non-letter publisher code");
                return;
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Non-digit body");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[")
          .append(code.substring(0, 3))
          .append("] YEAR: 20")
          .append(code.substring(3, 5))
          .append(" | CATALOG: ")
          .append(code.substring(5));

        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validate(sc.nextLine());
    }
}