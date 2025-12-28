package hnp.project.demoactivemq.test.o3014;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputN(scanner);
        List<Student> students = new ArrayList<>();
        int order = 1;
        for (int i = 0; i < n; i++) {
            String code = scanner.nextLine().trim();
            String name = scanner.nextLine().trim();
            String className = scanner.nextLine().trim();
            String email = scanner.nextLine().trim();
            String business = scanner.nextLine().trim();

            Student student = new Student(order++, code, name, className, email, business);
            students.add(student);
        }

        int q = inputN(scanner);

        for (int k = 0; k < q; k++) {
            String targetBusiness = scanner.nextLine().trim();
            List<Student> filteredList = students.stream()
                    .filter(s -> s.getBusinessShort().equals(targetBusiness))
                    .collect(Collectors.toList());
            filteredList.sort(Comparator.comparing(Student::getName));
            for (Student student : filteredList) {
                System.out.println(student.toString());
            }
        }
        scanner.close();
    }

    private static int inputN(Scanner scanner) {
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
}
