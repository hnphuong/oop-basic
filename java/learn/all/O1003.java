package hnp.project.demoactivemq.test.all;

import java.util.*;

public class O1003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            n = in.nextInt();
        } while (n <= 1 || n > 100);

        int m;
        do {
            m = in.nextInt();
        } while (m <= n || m > 100);
        //System.out.println("n: " + n + " ,m: " + m);
        Set<Integer> setN = inputData(n);
        Set<Integer> setM = inputData(m);
        //System.out.println(setN);
        //System.out.println(setM);
        List<Integer> list = new ArrayList<>();
        for (Integer i : setM) {
            if (checkData(i, setN)) {
                list.add(i);
            }
        }
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static Set<Integer> inputData(int m) {
        Scanner in = new Scanner(System.in);
        Set<Integer> setM = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int data;
            do {
                data = in.nextInt();
            } while (data < 1 || data > 1000);
            setM.add(data);
        }
        return setM;
    }

    private static Boolean checkData(int data, Set<Integer> set) {
        for (Integer i : set) {
            if (i == data) return true;
        }
        return false;
    }
}
