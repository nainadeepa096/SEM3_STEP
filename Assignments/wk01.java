package Assignments;

import java.util.Scanner;

class wk01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        boolean found = false;

        // Compare every seat with every other seat
        for (int i = 0; i < n-1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (seats[i] == seats[j]) {
                    System.out.println("Duplicate seat number: " + seats[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No duplicate seat numbers found.");
        }
    }
}
