package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
@Entity
@Table(name = "order")
@NamedQueries(
        @NamedQuery(name = "Order.findAll", query = "select  o from order o")
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
    }

    public Order(long id, Timestamp date, Employee employee, Customer customer) {
        this.id = id;
        this.date = date;
        this.employee = employee;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
