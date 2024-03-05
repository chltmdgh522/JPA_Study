package hellojpa;

import hellojpa.section10.*;
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
            Team team = new Team();
            team.setName("승호팀");

            Member member = new Member();
            member.setUserName("최승호");
            member.setTeam(team);
            member.setAge(25);

            team.getMembers().add(member);

            em.persist(member);
            em.flush();
            em.clear();

            List<Member> result = em.createQuery("select m from Member m inner join m.team t", Member.class)
                    .getResultList();

            List<Member> result2 = em.createQuery("select m from Member m left outer join m.team t", Member.class)
                    .getResultList();

            List<Member> result3 = em.createQuery("select m from Member m, Team t where m.userName = t.name", Member.class)
                    .getResultList();

            em.createQuery("select m from Member m left outer join m.team t where t.name='A'")
                            .getResultList();

            em.createQuery("select m from Member m left outer join Team t on m.userName= t.name")
                    .getResultList(); //연관관계 없는 조인



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
