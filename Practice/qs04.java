package Practice;
import java.util.Scanner;
public class qs04 {
    static void maskPhone(String phone){
        if(phone.length() != 10){
            System.out.println("Invalid phone number");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        System.out.println(sb);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String phone = sc.nextLine();

        maskPhone(phone);
}
