package vn.edu.iuh.fit.www_lab_week2.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!

@Entity
@Table(name = "product_price")
//@IdClass(ProductPrice.ProductPricePK.class)
public class ProductPrice {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @Column(nullable = false)
    private LocalDateTime price_date_time;
    @Column(nullable = false)
    private double price;
    private String note;
//
//    public static class ProductPricePK implements Serializable{
//        private long product_id;
//        private Timestamp price_date_time;
//
//        public ProductPricePK() {
//        }
//
//        public ProductPricePK(long product_id, Timestamp price_date_time) {
//            this.product_id = product_id;
//            this.price_date_time = price_date_time;
//        }
//    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
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

    public ProductPrice() {
    }

    public ProductPrice(Product product, LocalDateTime price_date_time, double price, String note) {
        this.product = product;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
