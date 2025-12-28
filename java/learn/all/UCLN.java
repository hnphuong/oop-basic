package hnp.project.demoactivemq.test.all;

import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String email = "dhgshfgsahjdfgdshfgsahfgsdahjfcgdbshfgdyfhgeukfbejfwhegdbhcnbdscndsmfbhdsfcbvdshfbvdshfvdfdshgfvdsfnvdshfgvdashfcevrfndvhcdv$12345@gmail.com";
        System.out.println(email.length());
//        while (t-- > 0) {
//            BigInteger n;
//            do{
//                n = in.nextBigInteger();
//            }while(n.equals(BigInteger.ZERO)||n>1e12);
//            //int n = in.nextInt();
//            int m = in.nextInt();
//            System.out.println("n: " + n + ", m: " + m);
//            int g;
//            g = gcd(n, m);
//            System.out.println("g: " + g);
//            System.out.println("lcm: " + 10e5);
//        }
    }

    static int gcd(int a, int b) {
        if (a == b) return a;
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
