package hnp.project.demoactivemq.test.O3001;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger numerator;
        do {
            numerator = in.nextBigInteger();
        } while (numerator.compareTo(BigInteger.ZERO) <= 0);
        BigInteger denominator;
        do {
            denominator = in.nextBigInteger();
        } while (denominator.compareTo(BigInteger.ZERO) <= 0);
        Fraction fraction = new Fraction(numerator, denominator);
        BigInteger gcd = gcd(fraction.getNumerator(), fraction.getDenominator());
        System.out.println(fraction.getNumerator().divide(gcd) + "/" + fraction.getDenominator().divide(gcd));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return b.equals(BigInteger.ZERO) ? a : gcd(b, a.mod(b));
    }


}
