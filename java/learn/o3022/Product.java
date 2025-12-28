package hnp.project.demoactivemq.test.o3022;

public class Product {
    private String code;
    private String name;
    private String unit;
    private Long price;
    private Long quantity;

    public Product(String code, String name, String unit, Long price, Long quantity) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
    }

    private Long calShippingFee() {
        return (long) Math.round((price * quantity) * 0.05);
    }

    private Long calMoney() {
        return (price * quantity) + calShippingFee();
    }

    private Long calPriceBuy(){
        Long money = calMoney();
        return money + (long) Math.round((money) * 0.02);
    }

    @Override
    public String toString() {
        return code + " " + name + " " + unit + " " + calShippingFee() + " " + calMoney() + " " + calPriceBuy();
    }
}
