package hellojpa;

import hellojpa.section6.Member;
import hellojpa.section6.Team;
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
            member.setUserName("승호");
            em.persist(member);

            Team team=new Team();
            team.setName("TeamA");
            team.getMembers().add(member);
            em.persist(team);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
