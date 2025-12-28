package hnp.project.demoactivemq.test.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class O1003_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //System.out.println(n + " : " + m);
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    list.add(a[i]);
                }
            }
        }
        list.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
