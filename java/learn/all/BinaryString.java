package hnp.project.demoactivemq.test.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryString {

    static void backTrack(int n, char[] s, int index, List<String> result) {
        if (index == n) {
            String rs = new String(s);
            System.out.println(s);
            result.add(rs);
            return;
        }
        s[index] = '0';
        backTrack(n, s, index + 1, result);
        s[index] = '1';
        backTrack(n, s, index + 1, result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s;
        int n = in.nextInt();
        int k = in.nextInt();
        s = new char[n];
        List<String> result = new ArrayList<>();
        backTrack(n, s, 0, result);
        System.out.println("-----------***-----------");
        for (String str : result) {
            if (str.contains(genString(k))) {
                System.out.println(str);
            }
        }
    }

    static String charToString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        return sb.toString();
    }

    static String genString(int k){
        return "0".repeat(Math.max(0, k));
    }
}
