package hnp.project.demoactivemq.test.o3019;

import java.util.Date;

public class Customer implements Comparable<Customer> {
    private String code;
    private String name;
    private Integer roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private Integer incidentalCharges;
    private Integer price;

    public Customer(String code, String name, Integer roomNumber, Date checkInDate, Date checkOutDate, Integer incidentalCharges) {
        this.code = code;
        this.name = name;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.incidentalCharges = incidentalCharges;
        this.price = calPrice();
    }

    @Override
    public String toString() {
        return code + " " + name + " " + roomNumber + " " + calDate() + " " + price;
    }

    private Integer calPrice() {
        return calDate() * priceFloor() + incidentalCharges;
    }

    private Integer calDate() {
        return (int) ((checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
    }

    private Integer priceFloor() {
        if (roomNumber / 100 == 1) {
            return 25;
        } else if (roomNumber / 100 == 2) {
            return 34;
        } else if (roomNumber / 100 == 3) {
            return 50;
        } else if (roomNumber / 100 == 4) {
            return 80;
        } else {
            return 1;
        }
    }

    @Override
    public int compareTo(Customer o) {
        return o.price.compareTo(this.price);
    }
}
