package Assignment;
import java.util.Scanner;

class as03{

    static void parseRecord(String line) {
        String[] fields = line.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0] +
                           " | SKU: " + fields[1] +
                           " | Qty: " + fields[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        parseRecord(line);
    }
}
