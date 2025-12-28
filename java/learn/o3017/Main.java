package hnp.project.demoactivemq.test.o3017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = inputLong(scanner, 1, 20);
        List<Bill> bills = new ArrayList<>();
        while (n-- > 0) {
            String code = inputString(scanner, 10);
            String name = inputStringNoSpace(scanner, 100);
            Long quantity = inputLong(scanner, 0, 50);
            Long price = inputLong(scanner, 0, (long) 1e11);
            Long discount = inputLong(scanner, 0, (long) 1e10);
            Bill bill = new Bill(code, name, quantity, price, discount);
            bills.add(bill);
        }
        Collections.sort(bills);
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }

    private static Long inputLong(Scanner scanner, int min, long size) {
        Long num = 0l;
        do {
            if (!scanner.hasNextLong()) {
                scanner.next();
                continue;
            }
            num = scanner.nextLong();
            scanner.nextLine();
        } while (num < min || num > size);
        return num;
    }

    private static String inputString(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > length || s.contains(" "));
        return s;
    }

    private static String inputStringNoSpace(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > length);
        return s;
    }
}
