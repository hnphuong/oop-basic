package hnp.project.demoactivemq.test.all;

import java.util.Scanner;

public class C01002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        do {
            t = in.nextInt();
        } while (t <= 0 || t > 100);
        String a[] = new String[t];
        for (int j = 0; j < t; j++) {
            do {
                a[j] = in.nextLine();
            } while (a[j].isEmpty() || a[j].length() > 80);
        }
        String b[] = new String[t];
        for (int j = 0; j < t; j++) {
            String s = a[j];
            String s1[] = s.trim().split(" ");
            String rs = "";
            for(int i = 0; i < s1.length; i++){
                String s2 = s1[i].trim().toLowerCase();
                String ss = s2.trim();
                if(ss.isEmpty()) continue;
                String l1 = ss.substring(0, 1).toUpperCase() + ss.substring(1).trim();
                rs += l1 + " ";
            }
            b[j] = rs.trim();
        }
        for (int j = 0; j < t; j++) {
            System.out.println(b[j]);
        }
    }
}
