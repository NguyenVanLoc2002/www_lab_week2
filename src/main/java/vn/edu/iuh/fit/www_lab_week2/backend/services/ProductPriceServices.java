package vn.edu.iuh.fit.www_lab_week2.backend.services;

import vn.edu.iuh.fit.www_lab_week2.backend.models.ProductPrice;
import vn.edu.iuh.fit.www_lab_week2.backend.reponsitories.ProductPriceReponsitory;

import java.util.List;

public class ProductPriceServices {
    private ProductPriceReponsitory productPriceReponsitory;

    public ProductPriceServices() {
        productPriceReponsitory = new ProductPriceReponsitory();
    }

    public List<ProductPrice> getAll(){
        return productPriceReponsitory.getAll();
    }

    public double getPriceByProductId(long id){
        return productPriceReponsitory.getPriceByProductId(id);
    }

    public List<ProductPrice> getListPriceByProductId(long id){
        return productPriceReponsitory.getListPriceByProductId(id);
    }
}
