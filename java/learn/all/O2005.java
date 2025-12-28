package hnp.project.demoactivemq.test.all;

import java.io.*;
import java.util.*;

public class O2005 {
    private static final int MAX_VALUE = 10000;
    private static final boolean[] isPrimeSieve = new boolean[MAX_VALUE];
    private static final int LIMIT_SQRT = (int) Math.sqrt(MAX_VALUE);
    private static final List<Integer> primes = new ArrayList<>(1229);

    private static void sieveOfEratosthenes() {
        Arrays.fill(isPrimeSieve, true);
        isPrimeSieve[0] = isPrimeSieve[1] = false;
        for (int p = 2; p <= LIMIT_SQRT; p++) {
            if (isPrimeSieve[p]) {
                for (int i = p * p; i < MAX_VALUE; i += p) {
                    isPrimeSieve[i] = false;
                }
            }
        }
        for (int i = 2; i < MAX_VALUE; i++) {
            if (isPrimeSieve[i]) primes.add(i);
        }
    }

    private static boolean isPrime(int n) {
        return n >= 2 && n < MAX_VALUE && isPrimeSieve[n];
    }

    public static void main(String[] args) {
        sieveOfEratosthenes();
        final int[] counts = new int[MAX_VALUE];

        final String fileName = "SONGUYEN.in";
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName), 1 << 20))) {

            @SuppressWarnings("unchecked")
            ArrayList<Integer> numbers = (ArrayList<Integer>) ois.readObject();

            for (int i = 0, n = numbers.size(); i < n; i++) {
                int x = numbers.get(i);
                if (isPrime(x)) counts[x]++;
            }
            System.out.println(Arrays.toString(Arrays.stream(counts).toArray()));
            StringBuilder sb = new StringBuilder(1 << 20);
            for (int p : primes) {
                int c = counts[p];
                if (c > 0) {
                    sb.append(p).append(' ').append(c).append('\n');
                }
            }
            if (sb.length() > 0) {
                System.out.print(sb.toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
