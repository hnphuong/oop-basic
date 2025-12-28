package hnp.project.demoactivemq.test.all;

import java.util.Scanner;

public class O1003s {
    private static final int MAX_VALUE = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[] isPresentInA = new boolean[MAX_VALUE];

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num > 0 && num < MAX_VALUE) {
                isPresentInA[num] = true;
            }
        }

        boolean[] isInIntersection = new boolean[MAX_VALUE];

        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();

            if (num > 0 && num < MAX_VALUE) {
                if (isPresentInA[num] && !isInIntersection[num]) {
                    isInIntersection[num] = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < MAX_VALUE; i++) {
            if (isInIntersection[i]) {
                result.append(i).append(" ");
            }
        }

        if (result.length() > 0) {
            System.out.println(result.toString().trim());
        }
        scanner.close();
    }
}
