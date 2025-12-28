package hnp.project.demoactivemq.test.o3020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputInt(scanner, 1, 50);
        int i = 1;
        List<Employee> employees = new ArrayList<>();
        while (n-- > 0) {
            String code = genCode(i);
            String name = scanner.nextLine();
            Long salaryDay = inputLong(scanner, 0, 10000000000l);
            Long salaryNumber = inputLong(scanner, 0, 30l);
            String position = scanner.nextLine();
            Employee employee = new Employee(code, name, salaryDay, salaryNumber, position);
            employees.add(employee);
            i++;
        }
        long sum = 0;
        for (Employee e : employees) {
            System.out.println(e);
            sum += e.getPriceReal();
        }
        System.out.println("Tong chi phi tien luong: " + sum);
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
        if (i < 10) return "NV0" + i;
        return "NV" + i;
    }
}
