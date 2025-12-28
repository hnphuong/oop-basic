package hnp.project.demoactivemq.test.all;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class O2006 {
    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        if (limit >= 2) {
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 2; i * i <= limit; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= limit; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Integer> readSerializedIntList(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(path), 1 << 20))) {
            Object obj = ois.readObject();
            return (ArrayList<Integer>) obj;
        }
    }

    public static void main(String[] args) {
        final String f1 = "DATA1.in";
        final String f2 = "DATA2.in";

        try {
            ArrayList<Integer> numbers1 = readSerializedIntList(f1);
            ArrayList<Integer> numbers2 = readSerializedIntList(f2);

            int maxVal = 0;
            for (int x : numbers1) if (x > maxVal) maxVal = x;
            for (int x : numbers2) if (x > maxVal) maxVal = x;

            if (maxVal < 2) {
                return;
            }

            boolean[] isPrime = sieveOfEratosthenes(maxVal);

            int[] cnt1 = new int[maxVal + 1];
            int[] cnt2 = new int[maxVal + 1];

            for (int i = 0, n = numbers1.size(); i < n; i++) {
                int v = numbers1.get(i);
                if (v >= 2 && v <= maxVal && isPrime[v]) cnt1[v]++;
            }
            for (int i = 0, n = numbers2.size(); i < n; i++) {
                int v = numbers2.get(i);
                if (v >= 2 && v <= maxVal && isPrime[v]) cnt2[v]++;
            }

            StringBuilder out = new StringBuilder(1 << 20);
            for (int p = 2; p <= maxVal; p++) {
                if (isPrime[p] && cnt1[p] > 0 && cnt2[p] > 0) {
                    out.append(p).append(' ')
                            .append(cnt1[p]).append(' ')
                            .append(cnt2[p]).append('\n');
                }
            }
            if (out.length() > 0) {
                System.out.print(out.toString());
            }

        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println("Lỗi khi đọc/giải tuần tự file: " + e.getMessage());
        }
    }
}
