package vn.edu.iuh.fit.www_lab_week2.backend.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

public class ProductPriceReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    private  final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceReponsitory() {
        em= Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans =  em.getTransaction();
    }

    public List<ProductPrice> getAll(){
        return em.createNamedQuery("ProductPrice.findAll",ProductPrice.class).getResultList();
    }

    public double getPriceByProductId(long id){
        LocalDateTime currentTime = LocalDateTime.now();
        TypedQuery<Double> query = em.createQuery(
                "select pp.price from  ProductPrice  pp " +
                "where pp.price_date_time =" +
                "(select MAX(pp1.price_date_time) from  ProductPrice  pp1 where pp1.price_date_time <=:currentTime and pp1.product.id=:id)"
                , Double.class);
        query.setParameter("currentTime",currentTime);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<ProductPrice> getListPriceByProductId(long id){
        TypedQuery<ProductPrice> query = em.createQuery("select pp from ProductPrice pp where pp.product.id=:id", ProductPrice.class);
        query.setParameter("id",  id);
        List<ProductPrice>  lst = query.getResultList();
        return lst;
    }
}
