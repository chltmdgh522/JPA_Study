package hellojpa;

import hellojpa.section10.Member;
import jakarta.persistence.*;

import java.util.List;


public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member =new Member();
            member.setUserName("최승호");
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
            List<Member> resultList = query.getResultList();
            Member singleResult = query.getSingleResult();

            List<Member> result = em.createQuery("select m from Member m where m.userName=:username", Member.class)
                    .setParameter("username", "최승호")
                    .getResultList();


            TypedQuery<String> query1 = em.createQuery("select m.userName from Member m", String.class);
            Query query2 = em.createQuery("select m.userName, m.age from Member m");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
