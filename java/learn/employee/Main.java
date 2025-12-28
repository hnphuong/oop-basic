package hnp.project.demoactivemq.test.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int i = 1;
        List<Employee> employees = new ArrayList<>();
        while (n-- > 0) {
            String employeeCode = genCode(i);
            Employee employee = new Employee(employeeCode, in.nextLine(), in.nextLine(), convertToDate(in.nextLine()), in.nextLine(), in.nextLine(), convertToDate(in.nextLine()));
            employees.add(employee);
            i++;
        }
        employees.sort(Comparator.comparing(Employee::getEmployeeDob));
        for(Employee e : employees){
            System.out.println(e.display());
        }
    }

    private static String genCode(int i) {
        if (i < 10) return "0000" + i;
        if (i < 100) return "000" + i;
        if (i < 1000) return "00" + i;
        if (i < 10000) return "0" + i;
        return "" + i;
    }

    private static Date convertToDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
