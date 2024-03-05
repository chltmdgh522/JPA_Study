package hellojpa;

import hellojpa.section9.Address;
import hellojpa.section9.AddressEntity;
import hellojpa.section9.Member;
import hellojpa.section9.Period;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;


public class JpaMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // List<Member> resultList = em.createQuery("select m from MEMBER9 m where m.username like '%kim%'", Member.class).getResultList();

            //Criteria 사용 준비
            CriteriaBuilder cb=em.getCriteriaBuilder(); //자바에서 제공해주는거임
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
            em.createQuery(cq).getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
