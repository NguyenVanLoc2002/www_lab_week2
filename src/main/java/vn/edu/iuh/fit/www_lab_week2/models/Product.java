package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.enums.ProductStatus;

import java.util.List;


//Ghi chú : do bài của em làm trên máy trường do tiết trước có bạn Minh Hồng
//ngồi làm nhưng không thoát GitHub trong intelliJ máy  em ngồi
//và  em không để ý nên đã commit bài nhầm vào tài khoản của bạn  chứ không phải em copy bài ạ!
@Entity
@Table(name = "product")
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "select p from product p")
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 300, nullable = false)
    private String description;

    @Column(length = 120, nullable = false)
    private String unit;
    @Column(length = 120, nullable = false)
    private String manufacturer_name;

    @Column(length = 300)
    private ProductStatus status;

    @OneToMany
    private List<ProductImage> productImages;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product() {
    }


    public Product(long id, String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                '}';
    }
}
