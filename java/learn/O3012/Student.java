package hnp.project.demoactivemq.test.O3012;

public class Student {
    private String code;
    private String name;
    private String className;
    private Double point1;
    private Double point2;
    private Double point3;

    public Student(String code, String name, String className, Double point1, Double point2, Double point3) {
        this.code = code;
        this.name = name;
        this.className = className;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public String toString() {
        return code + " " + name + " " + className + " " + point1 + " " + point2 + " " + point3;
    }

    public Double getPoint1() {
        return point1;
    }

    public Double getPoint2() {
        return point2;
    }

    public Double getPoint3() {
        return point3;
    }

    public String getCode() {
        return code;
    }
}
