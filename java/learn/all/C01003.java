package hnp.project.demoactivemq.test.all;

import java.util.Scanner;

public class C01003 {
    private static final int MAX_STRING_LENGTH = 1000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        do {
            t = in.nextInt();
        } while (t <= 0 || t > 100);
        String a, b;
        System.out.println("t: " + t);
        do {
            a = in.nextLine();
        } while (a.isEmpty() || a.length() > MAX_STRING_LENGTH);
        do {
            b = in.nextLine();
        } while (b.isEmpty() || b.length() > MAX_STRING_LENGTH);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
