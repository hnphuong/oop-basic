package hnp.project.demoactivemq.test.O3012;

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
            String code = inputStringNotSpace(in, 15);
            String name = inputString(in, 50);
            String className = inputStringNotSpace(in, 15);
            Double point1 = inputDouble(in);
            Double point2 = inputDouble(in);
            Double point3 = inputDouble(in);
            Student student = new Student(code, name, className, point1, point2, point3);
            students.add(student);
        }
        students.sort(Comparator.comparing(Student::getCode, String.CASE_INSENSITIVE_ORDER));
        int i = 1;
        for (Student s : students) {
            System.out.println(i + " " + s);
            i++;
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
        } while (number < 0 || number > 100);
        return number;
    }

    private static double inputDouble(Scanner scanner) {
        double number;
        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
            }
            number = scanner.nextDouble();
            scanner.nextLine();
        } while (number < 0 || number > 10);
        return number;
    }

    private static String inputString(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > length);
        return s;
    }

    private static String inputStringNotSpace(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine();
        } while (s.length() > length || s.contains(" "));
        return s;
    }
}
