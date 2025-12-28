package hnp.project.demoactivemq.test.o3014;

public class Student {
    private Integer order;
    private String code;
    private String name;
    private String className;
    private String email;
    private String businessShort;

    public Student(Integer order, String code, String name, String className, String email, String businessShort) {
        this.order = order;
        this.code = code;
        this.name = name;
        this.className = className;
        this.email = email;
        this.businessShort = businessShort;
    }

    public String getBusinessShort() {
        return businessShort;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return order + " " + code + " " + name + " " + className + " " + email + " " + businessShort;
    }

}
