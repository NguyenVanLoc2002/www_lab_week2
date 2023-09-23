package vn.edu.iuh.fit.www_lab_week2.backend.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.List;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
@Entity
@Table(name = "employee")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.employeeStatus = vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus.ACTIVE")
)

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime dob;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(length = 250, nullable = false)
    private String address;
    @Enumerated(EnumType.ORDINAL) // Ánh xạ enum thành giá trị số nguyên (1, 0, -1)
    @Column(name = "status", nullable = false)
    private EmployeeStatus employeeStatus;

    @JsonbTransient
    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;



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

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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

    public Employee(long id, String name, LocalDateTime dob, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Employee(long id, String name, LocalDateTime dob, String email, String phone, String address, EmployeeStatus employeeStatus, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeStatus = employeeStatus;
        this.orderList = orderList;
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
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}
