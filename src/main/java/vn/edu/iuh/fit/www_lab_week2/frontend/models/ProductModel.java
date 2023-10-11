package vn.edu.iuh.fit.www_lab_week2.frontend.models;

import vn.edu.iuh.fit.www_lab_week2.backend.models.Product;
import vn.edu.iuh.fit.www_lab_week2.backend.services.ProductServices;

import java.util.List;

public class ProductModel {
    private ProductServices productServices;

    public ProductModel() {
        productServices = new ProductServices();
    }

    public List<Product> getAll() {
        return productServices.getAll();
    }

}
