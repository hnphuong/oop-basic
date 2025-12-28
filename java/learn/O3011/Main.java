package hnp.project.demoactivemq.test.O3011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (in.hasNextLine()) {
            String code = inputStringNotSpace(in, 15);
            String name = inputString(in, 100);
            String className = inputStringNotSpace(in, 15);
            String email = inputStringNotSpace(in, 50);
            Student student = new Student(code, name, className, email);
            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getCode));

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static String inputString(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine().trim();
        } while (s.length() > length);
        return s;
    }

    private static String inputStringNotSpace(Scanner scanner, int length) {
        String s;
        do {
            s = scanner.nextLine().trim();
        } while (s.length() > length || s.contains(" "));
        return s;
    }
}
