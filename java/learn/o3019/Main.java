package hnp.project.demoactivemq.test.o3019;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputInt(scanner, 1, 20);
        int i = 1;
        List<Customer> customers = new ArrayList<>();
        while (n-- > 0) {
            String code = genCode(i);
            String name = scanner.nextLine();
            Integer roomNumber = inputInt(scanner, 1, 1000);
            Date inDate = convertData(scanner.nextLine());
            Date outDate = convertData(scanner.nextLine());
            Integer incidentalCharges = inputInt(scanner, 0, 1000);
            Customer customer = new Customer(code, name, roomNumber, inDate, outDate, incidentalCharges);
            customers.add(customer);
            i++;
        }
        Collections.sort(customers);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
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
        if (i < 10) return "KH0" + i;
        return "KH" + i;
    }

    private static Date convertData(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
