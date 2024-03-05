package hellojpa;

import hellojpa.section10.Address;
import hellojpa.section10.Member;
import hellojpa.section10.MemberDto;
import hellojpa.section10.Order;
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
            for(int i=0; i<100; i++) {
                Member member = new Member();
                member.setUserName("최승호"+i);
                member.setAge(25+i);
                em.persist(member);
            }
            em.flush();
            em.clear();

            List<Member> resultList = em.createQuery("select m from Member m order by m.age desc ", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(10)
                    .getResultList();

            for (Member member1 : resultList) {
                System.out.println(member1.getUserName());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
