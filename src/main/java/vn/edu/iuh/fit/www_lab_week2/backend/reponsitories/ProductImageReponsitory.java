package vn.edu.iuh.fit.www_lab_week2.backend.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.ProductImage;

import java.util.List;

public class ProductImageReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }

    public List<ProductImage> getAll() {
        return em.createNamedQuery("ProductImage.findAll", ProductImage.class).getResultList();
    }

    public List<ProductImage> findProductImageByProductId(long id) {
        TypedQuery<ProductImage> query = em.createQuery("select pm  from ProductImage pm where pm.product.id=:id", ProductImage.class);
        query.setParameter("id", id);
        List<ProductImage> lst = query.getResultList();
        if(lst == null) return null;
        return lst;
    }
}
