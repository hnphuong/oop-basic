package kiemtra01;
import java.io.*;
import java.util.*;

public class Bai3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("DATA.in"));
        long sum = 0; String s = "";
        while(sc.hasNext()){
            try{      
                s = sc.next();
                int n = Integer.parseInt(s);
            }catch(NumberFormatException e1){
                try{
                    long x = Long.parseLong(s);
                    sum += x;
                }
                catch(Exception e2){}
            }
        }
        System.out.println(sum);
    }
}

