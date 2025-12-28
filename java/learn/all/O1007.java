package hnp.project.demoactivemq.test.all;

import java.util.Scanner;

public class O1007 {
    public static String checkAndCount(String s) {
        int n = s.length();
        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return "INVALID";
            }
        }

        if (n > 0 && s.charAt(0) == '0') {
            return "INVALID";
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        if (countEven == countOdd) {
            return "NO";
        }

        if (n % 2 == 0) {
            if (countEven > countOdd) {
                return "YES";
            } else {
                return "NO";
            }
        }

        else {
            if (countOdd > countEven) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            System.out.println(checkAndCount(s));
        }
        scanner.close();
    }
}
