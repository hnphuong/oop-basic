package hnp.project.demoactivemq.test.O3008;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Integer code = 1;
        List<Product> products = new ArrayList<>();
        while (n-- > 0) {
            String name = in.nextLine();
            String group = in.nextLine();
            Double buy = input(in);
            Double sell = input(in);
            Product product = new Product(code, name, group, buy, sell);
            products.add(product);
            code++;
        }
        products.sort(Comparator.comparing(Product::price).reversed());
        for(Product p : products){
            System.out.println(p);
        }
    }

    private static Double input(Scanner scanner) {
        double number;
        String numStr = "";
        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
            }
            number = scanner.nextDouble();
            scanner.nextLine();
            numStr = String.valueOf(Math.abs(number)).replace(".", "");
        } while (number < 0 || numStr.length() > 9);
        return number;
    }
}
