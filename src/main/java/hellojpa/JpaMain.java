package hellojpa;

import hellojpa.section9.Address;
import hellojpa.section9.Member;
import hellojpa.section9.Period;
import jakarta.persistence.*;


public class JpaMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member=new Member();
            member.setUsername("최승호");
            member.setHoneAddress(new Address("서울","경리단길","1000"));
            member.setWordPeriod(new Period());
            em.persist(member);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
