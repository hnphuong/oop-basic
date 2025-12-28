package hnp.project.demoactivemq.test.all;

import java.math.BigInteger;
import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
}
