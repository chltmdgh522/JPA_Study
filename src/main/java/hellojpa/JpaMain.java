package hellojpa;

import hellojpa.section5.Member;
import hellojpa.section5.Team;
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
            Team team=new Team();
            team.setName("d");

            Member member=new Member();
            member.setUserName("승호");
            member.setTeam(team);


            em.persist(team);
            em.persist(member);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            System.out.println(findMember.getTeam().getClass()); // 지연로딩일 시 프록시로 가져온것을 확인할 수 있음

            System.out.println(findMember.getTeam().getName()); // 지연로딩일 시 초기화가 일어나면서 팀 쿼리 호출

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
