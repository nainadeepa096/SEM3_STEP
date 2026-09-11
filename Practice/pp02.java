import java.util.Scanner;
import java.util.Arrays;
class pp02{
    static boolean iterativeCheck(String str) {
        int left = 0;
        int right = str.length() - 1;

         while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
    static boolean recursiveCheck(String str, int left, int right) {
        if (left >= right)
            return true;
        
        if (str.charAt(left) != str.charAt(right))
            return false;

        return recursiveCheck(str, left + 1, right - 1);
    }

    static boolean arrayReverseCheck(String str) {
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(arr);
        return str.equals(reversed);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String str = sc.nextLine();

        boolean result1 = iterativeCheck(str);
        boolean result2 = recursiveCheck(str, 0, str.length() - 1);
        boolean result3 = arrayReverseCheck(str);

        System.out.println("Iterative Check: " + result1);
        System.out.println("Recursive Check: " + result2);
        System.out.println("Array Reversal Check: " + result3);

        sc.close();
    }   
}


