package vn.edu.iuh.fit.www_lab_week2.models;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private long id;
    private Timestamp order_date;
    private long emp_id;
    private long cust_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public Order() {
    }

    public Order(long id, Timestamp order_date, long emp_id, long cust_id) {
        this.id = id;
        this.order_date = order_date;
        this.emp_id = emp_id;
        this.cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", emp_id=" + emp_id +
                ", cust_id=" + cust_id +
                '}';
    }
}
