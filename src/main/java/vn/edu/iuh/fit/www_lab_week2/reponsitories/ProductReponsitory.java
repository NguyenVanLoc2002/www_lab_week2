package vn.edu.iuh.fit.www_lab_week2.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.models.Customer;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;
import vn.edu.iuh.fit.www_lab_week2.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertProduct(Product product) {
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> findById(long id){
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.id=:id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();
        return product == null ? Optional.empty() : Optional.of(product);
    }

    public List<Product> getAll(){
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

}
