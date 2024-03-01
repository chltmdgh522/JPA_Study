package hellojpa;

import hellojpa.section5.Member;
import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.List;


public class JpaMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member=new Member();
            member.setUserName("승호");
            
            em.persist(member);
            em.flush();
            em.clear();

            Member find=em.find(Member.class,member.getId());

            em.detach(find);


            System.out.println("find.getClass() = " + find.getClass());


//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId()); //이 값이 사용될때만 쿼리 나감
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getUserName());

            System.out.println(emf.getPersistenceUnitUtil().isLoaded(findMember)); // 프록시 초기화 여부 확인


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
