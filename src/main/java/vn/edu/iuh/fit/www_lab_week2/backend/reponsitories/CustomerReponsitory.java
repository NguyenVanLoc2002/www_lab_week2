package vn.edu.iuh.fit.www_lab_week2.backend.reponsitories;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerReponsitory {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertCus(Customer customer){
        try{
            trans.begin();
            em.persist(customer);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCus(Customer customer){
        try{
            trans.begin();
            em.merge(customer);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<Customer> findById(long id){
        TypedQuery<Customer> query = em.createQuery("select c from Customer c  where c.id=:id", Customer.class);
        query.setParameter("id", id);
        Customer customer = query.getSingleResult();
        return customer == null ? Optional.empty() : Optional.of(customer);
    }


    public List<Customer> getAll(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
