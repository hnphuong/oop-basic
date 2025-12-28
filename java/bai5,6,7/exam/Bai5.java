package exam;
import java.io.*;
import java.util.*;

public class Bai5 {
    static class Student {
        String id;
        String name;
        String className;
        String email;
        String phone;

        public Student(String id, String name, String className, String email, String phone) {
            this.id = id;
            this.name = name;
            this.className = className;
            this.email = email;
            this.phone = "0" + phone; // bổ sung số 0
        }

        @Override
        public String toString() {
            return id + " " + name + " " + className + " " + email + " " + phone;
        }
    }

    static Scanner getScanner() throws FileNotFoundException {
        File f = new File("DANHSACH.in");
        if (f.exists()) {
            return new Scanner(f);
        }
        return new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("WORKING DIR = " + System.getProperty("user.dir"));
        Scanner sc = getScanner();
        List<Student> list = new ArrayList<>();

        while (true) {
            if (!sc.hasNextLine()) {
                break;
            }
            String id = sc.nextLine().trim();
            if (id.isEmpty()) continue;

            if (!sc.hasNextLine()) break;
            String name = sc.nextLine().trim();

            if (!sc.hasNextLine()) break;
            String className = sc.nextLine().trim();

            if (!sc.hasNextLine()) break;
            String email = sc.nextLine().trim();

            if (!sc.hasNextLine()) break;
            String phone = sc.nextLine().trim();

            list.add(new Student(id, name, className, email, phone));
        }

        // Sắp xếp theo lớp, rồi theo mã sinh viên
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (!a.className.equals(b.className)) {
                    return a.className.compareTo(b.className);
                }
                return a.id.compareTo(b.id);
            }
        });

        // In kết quả
        for (Student s : list) {
            System.out.println(s);
        }
    }
    ///javac exam/Bai5.java
    //java exam.Bai5
}
