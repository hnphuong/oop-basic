package hnp.project.demoactivemq.test.o3017;

public class Bill implements Comparable<Bill> {
    private String code;
    private String nameProduct;
    private Long quantity;
    private Long price;
    private Long discount;
    private Long sumPrice;

    public Bill(String code, String nameProduct, Long quantity, Long price, Long discount) {
        this.code = code;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.sumPrice = calSumPrice();
    }

    @Override
    public String toString() {
        return code + " " + nameProduct + " " + quantity + " " + price + " " + discount + " " + sumPrice;
    }

    public Long calSumPrice() {
        return price * quantity - discount;
    }

    @Override
    public int compareTo(Bill o) {
        return o.sumPrice.compareTo(this.sumPrice);
    }
}
