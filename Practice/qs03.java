package Practice;
import java.util.Scanner;

public class qs03 {
    static void validate(String filename){
        int dot = filename.lastIndexOf('.');
        String ext = filename.substring(dot+1);

         if (ext.equalsIgnoreCase("pdf") ||
            ext.equalsIgnoreCase("docx") ||
            ext.equalsIgnoreCase("zip"))
            System.out.println("Accepted");
        else
            System.out.println("Rejected — invalid file type");
    }
      public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String filename = sc.nextLine();

        validate(filename);
    }
    
}
