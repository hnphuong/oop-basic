package hnp.project.demoactivemq.test.o3018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        List<Student> students = new ArrayList<>();
        int c = 1;
        while (i-- > 0) {
            String code = genCode(c);
            String name = scanner.nextLine();
            Double pointTheory = inputDouble(scanner);
            Double pointPractice = inputDouble(scanner);
            Student student = new Student(code, name, inputDoubleS(pointTheory), inputDoubleS(pointPractice));
            students.add(student);
            c++;
        }
        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static Double inputDouble(Scanner scanner) {
        double num = 0.0;
        do {
            if (!scanner.hasNextDouble()) {
                scanner.next();
                continue;
            }
            num = scanner.nextDouble();
            scanner.nextLine();
        } while (num < 0 || num > 100);
        return num;
    }

    private static Double inputDoubleS(Double number) {
        if (number == 10.0 || number < 10.0) {
            return number;
        }
        if (number % 1 == 0 && number > 10 && number < 100) {
            return number / 10.0;
        }
        return number;
    }

    private static String genCode(int i) {
        if (i < 10) return "TS0" + i;
        return "TS" + i;
    }
}
