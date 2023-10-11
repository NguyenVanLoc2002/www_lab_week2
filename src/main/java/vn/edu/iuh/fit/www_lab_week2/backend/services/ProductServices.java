package vn.edu.iuh.fit.www_lab_week2.backend.services;

import vn.edu.iuh.fit.www_lab_week2.backend.models.Order;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Product;
import vn.edu.iuh.fit.www_lab_week2.backend.reponsitories.ProductReponsitory;

import java.util.List;

public class ProductServices {
    private ProductReponsitory  productReponsitory;

    public ProductServices() {
        productReponsitory = new ProductReponsitory();
    }

    public List<Product> getAll(){
        return productReponsitory.getAll();
    }
}
