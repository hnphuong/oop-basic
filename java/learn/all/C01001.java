package hnp.project.demoactivemq.test.all;

import java.util.Arrays;
import java.util.Scanner;

public class C01001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        do {
            t = in.nextInt();
        } while (t <= 0 || t > 10);
        for (int j = 0; j < t; j++) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
        }
    }
}
