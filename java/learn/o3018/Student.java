package hnp.project.demoactivemq.test.o3018;

public class Student implements Comparable<Student> {
    private String code;
    private String name;
    private Double pointTheory;
    private Double pointPractice;
    private Double pointMedium;

    public Student(String code, String name, Double pointTheory, Double pointPractice) {
        this.code = code;
        this.name = name;
        this.pointTheory = pointTheory;
        this.pointPractice = pointPractice;
        this.pointMedium = pointMedium();
    }

    @Override
    public String toString() {
        return code + " " + name + " " + String.format("%.2f", pointMedium) + " " + classification();
    }

    private Double pointMedium() {
        return (pointTheory + pointPractice) / 2;
    }

    private String classification() {
        double point = pointMedium;
        if (point > 9.5) {
            return "XUAT SAC";
        } else if (point >= 8) {
            return "DAT";
        } else if (point >= 5) {
            return "CAN NHAC";
        } else {
            return "TRUOT";
        }
    }

    @Override
    public int compareTo(Student o) {
        return o.pointMedium.compareTo(this.pointMedium);
    }
}
