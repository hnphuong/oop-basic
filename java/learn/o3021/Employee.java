package hnp.project.demoactivemq.test.o3021;

public class Employee implements Comparable<Employee> {
    private String code;
    private String name;
    private Long salaryDay;
    private Long salaryNumber;
    private String position;
    private Long priceReal;

    public Employee(String code, String name, Long salaryDay, Long salaryNumber, String position) {
        this.code = code;
        this.name = name;
        this.salaryDay = salaryDay;
        this.salaryNumber = salaryNumber;
        this.position = position;
        this.priceReal = calculateSalary() + calculateBonus() + calculateAllowance();
    }

    @Override
    public String toString() {
        return code + " " + name + " " + calculateSalary() + " " + calculateBonus() + " " + calculateAllowance() + " " + priceReal;
    }

    private Long calculateSalary() {
        return salaryDay * salaryNumber;
    }

    private Long calculateBonus() {
        if (salaryNumber >= 25) {
            return (long) Math.floor(calculateSalary() * 0.2);
        } else if (salaryNumber >= 22) {
            return (long) Math.floor(calculateSalary() * 0.1);
        } else {
            return 0L;
        }
    }

    private Long calculateAllowance() {
        switch (position) {
            case "GD":
                return 250000L;
            case "PGD":
                return 200000L;
            case "TP":
                return 180000L;
            case "NV":
                return 150000L;
            default:
                return 0L;
        }
    }

    @Override
    public int compareTo(Employee o) {
        return o.priceReal.compareTo(this.priceReal);
    }
}
