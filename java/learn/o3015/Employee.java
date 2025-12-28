package hnp.project.demoactivemq.test.o3015;

public class Employee {
    private String code;
    private String name;
    private Integer salaryDay;
    private Integer salaryNumber;
    private String position;

    public Employee(String code, String name, Integer salaryDay, Integer salaryNumber, String position) {
        this.code = code;
        this.name = name;
        this.salaryDay = salaryDay;
        this.salaryNumber = salaryNumber;
        this.position = position;
    }

    public String toString() {
        return code + " " + name + " " + salaryMonth() + " " + bonus() + " " + allowance() + " " + (salaryMonth() + bonus() + allowance());
    }

    public Integer salaryMonth() {
        return (salaryDay * salaryNumber);
    }

    public Integer bonus() {
        int salary = salaryDay * salaryNumber;
        if (salaryNumber > 25) {
            return (int) Math.floor(salary * 0.2);
        } else if (salaryNumber >= 22) {
            return (int) Math.floor(salary * 0.1);
        } else {
            return 0;
        }
    }

    private Integer allowance() {
        switch (position) {
            case "GD":
                return 250000;
            case "PGD":
                return 200000;
            case "TP":
                return 180000;
            case "NV":
                return 150000;
            default:
                return 0;
        }
    }
}
