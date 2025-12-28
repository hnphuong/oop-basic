package hnp.project.demoactivemq.test.all;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class O1011S {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            Set<Integer> evenSet = new TreeSet<>();
            Set<Integer> oddSet = new TreeSet<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num % 2 == 0) {
                    evenSet.add(num);
                } else {
                    oddSet.add(num);
                }
            }

            for (int num : evenSet) {
                System.out.print(num + " ");
            }
            System.out.println();

            for (int num : oddSet) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
