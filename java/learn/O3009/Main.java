package hnp.project.demoactivemq.test.O3009;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = input(in);
        List<Student> students = new ArrayList<>();
        while (n-- > 0) {
            String code = inputString(in, 100);
            String name = inputString(in, 100);
            String className = inputString(in, 100);
            String email = inputString(in, 100);
            Student student = new Student(code, name, className, email);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student::getClassName).thenComparing(Student::getCode));
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static Integer input(Scanner scanner) {
        int number;
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            number = scanner.nextInt();
            scanner.nextLine();
        } while (number < 0 || number > 1000);
        return number;
    }

    private static String inputString(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > length);
        return s;
    }
}
