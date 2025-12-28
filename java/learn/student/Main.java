package hnp.project.demoactivemq.test.student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String studentCode = in.nextLine();
            String studentName = in.nextLine();
            String studentSex = in.nextLine();
            String studentClass = in.nextLine();
            String studentEmail = in.nextLine();
            String studentPhone = in.nextLine();
            Student student = new Student(studentCode, studentName, studentSex, studentClass, studentEmail, studentPhone);
            System.out.println(student.display());
        }
    }
}
