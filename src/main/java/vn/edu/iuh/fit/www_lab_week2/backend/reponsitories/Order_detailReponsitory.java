package vn.edu.iuh.fit.www_lab_week2.backend.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Order_detail;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Product;

import java.util.List;
import java.util.Optional;

public class Order_detailReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Order_detailReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertOrderDetail(Order_detail orderDetail) {
        try {
            trans.begin();
            em.persist(orderDetail);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrderDetail(Order_detail orderDetail) {
        try {
            trans.begin();
            em.merge(orderDetail);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> findById(long order_id, long product_id){
        TypedQuery<Product> query = em.createQuery("select od from Order_detail od where od.order.id=:orid and od.product.id=:pid", Product.class);
        query.setParameter("orid", order_id);
        query.setParameter("pid", product_id);
        Product product = query.getSingleResult();
        return product == null ? Optional.empty() : Optional.of(product);
    }

    public List<Product> getAll(){
        return em.createNamedQuery("Order_detail.findAll", Product.class).getResultList();
    }

}
