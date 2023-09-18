package vn.edu.iuh.fit.www_lab_week2.models;

import java.sql.Timestamp;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
public class ProductPrice {
    private long product_id;
    private Timestamp price_date_time;
    private double price;
    private String note;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public Timestamp getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(Timestamp price_date_time) {
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

    public ProductPrice(long product_id, Timestamp price_date_time, double price, String note) {
        this.product_id = product_id;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "product_price{" +
                "product_id=" + product_id +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
