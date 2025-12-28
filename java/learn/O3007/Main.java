package hnp.project.demoactivemq.test.O3007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = new ArrayList<>();
        Double maxSum = 0.0;
        for (int code = 1; code <= n; code++) {
            String name = scanner.nextLine();

            String dob = scanner.nextLine();

            Double subject1 = inputScore(scanner);
            Double subject2 = inputScore(scanner);
            Double subject3 = inputScore(scanner);

            Student student = new Student(code, name, dob, subject1, subject2, subject3);
            students.add(student);

            Double sum = student.sum();
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        for (Student s : students) {
            if (Math.abs(s.sum() - maxSum) < 1e-6) {
                System.out.println(s);
            }
        }

        scanner.close();
    }

    private static Double inputScore(Scanner scanner) {
        Double score;
        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
            }
            score = scanner.nextDouble();
        } while (score < 0.0 || score > 10.0);
        scanner.nextLine();
        return score;
    }

    private static Date convertToDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format, expected dd/MM/yyyy");
        }
    }
}
