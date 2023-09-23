package vn.edu.iuh.fit.www_lab_week2.backend.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.www_lab_week2.backend.models.Order;

import java.util.List;
import java.util.Optional;

public class OrderReponsitory {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderReponsitory() {
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertOrder(Order order) {
        try {
            trans.begin();
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(Order order) {
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteOrder(long id) {
        try {
            trans.begin();
            Optional<Order> op = findByOrderId(id);
            if (op.isPresent()) {
                Order order = op.get();
                em.remove(order);
                return true;
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Order> findByOrderId(long id) {
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.id=:id", Order.class);
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        return order == null ? Optional.empty() : Optional.of(order);
    }

    public List<Order> findByEmployeeId(long id) {
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.employee.id=:id", Order.class);
        query.setParameter("id", id);
        List<Order> list = query.getResultList();
        if(list == null) {
            return null;
        }
        return list;
    }

    public List<Order> getAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }
}
