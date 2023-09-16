package vn.edu.iuh.fit.www_lab_week2.models;

import java.sql.Timestamp;
import java.util.Date;

public class product_price {
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

    public product_price() {
    }

    public product_price(long product_id, Timestamp price_date_time, double price, String note) {
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
