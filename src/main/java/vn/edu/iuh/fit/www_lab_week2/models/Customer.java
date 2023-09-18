package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
@Entity
@Table(name = "customer")
@NamedQueries(
        @NamedQuery(name = "Customer.findAll", query = "select c from customer c ")
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;

    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;
    @Column(name = "email" , length = 70, nullable = false)
    private String email;
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    @Column(name = "address" , length = 200, nullable = false)
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer() {
    }

    public Customer(long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
