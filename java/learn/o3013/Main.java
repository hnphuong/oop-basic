package hnp.project.demoactivemq.test.o3013;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputInt(scanner);
        List<Person> persons = new ArrayList<>();
        while (n-- > 0) {
            String data = scanner.nextLine();
            String[] parts = data.split(" ");
            if (parts.length < 2) continue;

            String name = parts[0];
            String age = parts[1];
            Date dob = convertToDate(age);
            Person person = new Person(name, dob);
            persons.add(person);
        }

        persons.sort(Comparator.comparing(Person::getDob, Comparator.nullsLast(Comparator.naturalOrder())).reversed());

        if (!persons.isEmpty()) {
            System.out.println(persons.get(0).toDisplayString());

            System.out.println(persons.get(persons.size() - 1).toDisplayString());
        }

        scanner.close();
    }

    private static int inputInt(Scanner scanner) {
        int n = 0;
        do {
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            n = scanner.nextInt();
            scanner.nextLine();
        } while (n < 0 || n > 100);
        return n;
    }

    private static Date convertToDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }
}