package vn.edu.iuh.fit.www_lab_week2.models;

//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
public class Order_detail {
    private long id;
    private String product_id;
    private int quantity;
    private double price;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public Order_detail(long id, String product_id, int quantity, double price, String note) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order_detail{" +
                "id=" + id +
                ", product_id='" + product_id + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
