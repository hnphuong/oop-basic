package hnp.project.demoactivemq.test.o3013;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String name;
    private Date dob;

    public Person(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return name + " " + convertToString(dob);
    }

    public String toDisplayString() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    private String convertToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
