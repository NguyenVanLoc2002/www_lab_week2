package vn.edu.iuh.fit.www_lab_week2.models;

//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_detail")
@IdClass(Order_detail.OrderProductPK.class)
public class Order_detail {
    @Id
    private long order_id;

    @Id
    private long product_id;

    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    private String note;

    @OneToMany
    private List<Product> products;

    public static class OrderProductPK implements Serializable{
        private long order_id;
        private long product_id;

        public OrderProductPK() {
        }

        public OrderProductPK(long order_id, long product_id) {
            this.order_id = order_id;
            this.product_id = product_id;
        }
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Order_detail() {
    }

    public Order_detail(long order_id, long product_id, int quantity, double price, String note) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order_detail{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
