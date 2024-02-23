package jpabook.jpashop;

import jakarta.persistence.*;
import jpabook.jpashop.jpadomain.Order;
import jpabook.jpashop.jpadomain.OrderItem;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Order order=new Order();
            order.addOrderItem(new OrderItem());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }
        emf.close();
    }
}
