package hnp.project.demoactivemq.test.O3008;

public class Product {
    private Integer code;
    private String name;
    private String group;
    private Double priceBuy;
    private Double priceSell;

    public Product(Integer code, String name, String group, Double priceBuy, Double priceSell) {
        this.code = code;
        this.name = name;
        this.group = group;
        this.priceBuy = priceBuy;
        this.priceSell = priceSell;
    }

    public String toString() {
        return code + " " + name + " " + group + " " + String.format("%.2f", (priceSell - priceBuy));
    }

    public Double price(){
        return priceSell - priceBuy;
    }
}
