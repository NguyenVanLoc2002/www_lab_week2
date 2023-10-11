package vn.edu.iuh.fit.www_lab_week2.backend.services;

import vn.edu.iuh.fit.www_lab_week2.backend.models.ProductImage;
import vn.edu.iuh.fit.www_lab_week2.backend.reponsitories.ProductImageReponsitory;

import java.util.List;

public class ProductImageServices {
    private ProductImageReponsitory productImageReponsitory;

    public ProductImageServices() {
        productImageReponsitory = new ProductImageReponsitory();
    }

    public List<ProductImage> findProductImageByProductId(long id) {
        return productImageReponsitory.findProductImageByProductId(id);
    }
}
