package kiemtra01;

import java.io.*;
import java.math.*;
import java.util.*;

public class Bai1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        BigInteger tong = new BigInteger("0");
        BigInteger tich = new BigInteger("1");
        while(sc.hasNext()){
            BigInteger x = sc.nextBigInteger();
            tong = tong.add(x);
            tich = tich.multiply(x);
        }
        System.out.println(tong);
        System.out.println(tich);
    }
}