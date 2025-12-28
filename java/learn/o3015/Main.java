package hnp.project.demoactivemq.test.o3015;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = genCode(1);
        String name = scanner.nextLine();
        Integer salary = scanner.nextInt();
        scanner.nextLine();
        Integer salaryNumber = scanner.nextInt();
        scanner.nextLine();
        String position = inputPosition(scanner);
        Employee employee = new Employee(code, name, salary, salaryNumber, position);
        System.out.println(employee);
    }

    private static String inputPosition(Scanner scanner) {
        String position;
        do {
            position = scanner.nextLine();
        } while (position == null || checkPosition(position));
        return position;
    }

    private static boolean checkPosition(String position) {
        switch (position) {
            case "GD":
            case "PGD":
            case "TP":
            case "NV":
                return false;
            default:
                return true;
        }
    }

    private static String genCode(int i) {
        if (i < 10) return "NV0" + i;
        return "NV" + i;
    }
}
