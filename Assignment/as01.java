package Assignment;
import java.util.Scanner;

class as01 {

    static void checkPIN(String pin) {

        if (pin.length() != 4)
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        else
            System.out.println("PIN length OK.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String pin = sc.nextLine();

        checkPIN(pin);
    }
}

