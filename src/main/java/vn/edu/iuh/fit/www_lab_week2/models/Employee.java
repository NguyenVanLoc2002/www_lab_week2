package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;

import java.sql.Date;
import java.util.List;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
@Entity
@Table(name = "employee")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from employee e where e.status =1")
)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String name;
    @Column(nullable = false)
    private Date dob;
    @Column(unique = true, length = 150)
    private String email;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(length = 250, nullable = false)
    private String address;

    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    private EmployeeStatus status;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeStatus getStatus() {
        return status;
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



    public Employee() {
    }

    public Employee(long id, String name, Date dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
