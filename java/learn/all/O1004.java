package hnp.project.demoactivemq.test.all;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class O1004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<BigInteger> list = new ArrayList<>();
        while (n-- > 0) {
            BigInteger a = in.nextBigInteger();
            list.add(a);
        }
        print(list);
    }

    private static void print(List<BigInteger> list) {
        for (BigInteger d : list) {
            boolean check = isPalindrome(d);
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPalindrome(BigInteger a) {
        String s = a.toString();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (isOdd(s.charAt(left)) || s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isOdd(char a) {
        BigInteger two = BigInteger.valueOf(a);
        return two.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE);
    }
}
