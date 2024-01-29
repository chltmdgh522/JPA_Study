package hellojpa;

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
            Member member=new Member();
            member.setUsername("A");
            member.setRoleType(RoleType.USER);

            Member member1=new Member();
            member1.setUsername("A");
            member1.setRoleType(RoleType.USER);

            Member member2=new Member();
            member2.setUsername("A");
            member2.setRoleType(RoleType.USER);

            System.out.println("=============");
            em.persist(member);
            em.persist(member1);
            System.out.println("=============");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
