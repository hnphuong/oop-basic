package hnp.project.demoactivemq.test.O3009;

public class Student {
    private String code;
    private String name;
    private String className;
    private String email;

    public Student(String code, String name, String className, String email) {
        this.code = code;
        this.name = name;
        this.className = className;
        this.email = email;
    }

    public String toString() {
        return code + " " + name + " " + className + " " + email;
    }

    public String getClassName() {
        return className;
    }

    public String getCode() {
        return code;
    }
}
