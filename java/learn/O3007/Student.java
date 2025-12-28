package hnp.project.demoactivemq.test.O3007;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private Integer code;
    private String name;
    private String dob;
    private Double subject1;
    private Double subject2;
    private Double subject3;

    public Student(Integer code, String name, String dob, Double subject1, Double subject2, Double subject3) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public Double sum() {
        return subject1 + subject2 + subject3;
    }

    public String toString() {
        return code + " " + name.trim() + " " +dob + " " + (subject1 + subject2 + subject3);
    }

    private String convertToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
