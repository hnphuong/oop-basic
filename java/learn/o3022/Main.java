package hnp.project.demoactivemq.test.o3022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = inputInt(sc, 1, 50);
        List<Product> products = new ArrayList<>();
        int i = 1;
        while (n-- > 0) {
            String code = genCode(i);
            String name = sc.nextLine();
            String unit = sc.nextLine();
            Long price = inputLong(sc, 1, 1000000000);
            Long quantity = inputLong(sc, 1, 10000);
            Product product = new Product(code, name, unit, price, quantity);
            products.add(product);
            i++;
        }
        for(Product p : products){
            System.out.println(p);
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

    private static Integer inputInt(Scanner scanner, int min, int size) {
        int num = 0;
        do {
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            num = scanner.nextInt();
            scanner.nextLine();
        } while (num < min || num > size);
        return num;
    }

    private static String genCode(int i) {
        if (i < 10) return "MH0" + i;
        return "MH" + i;
    }
}
