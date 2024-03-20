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
            em.persist(team);

            Team team1 = new Team();
            team1.setName("호호팀");
            em.persist(team1);


            Member member = new Member();
            member.setUserName("최승호1");
            member.setTeam(team);
            member.setAge(25);
            member.setMemberType(MemberType.User);
            em.persist(member);

            Member member2 = new Member();
            member2.setUserName("최승호2");
            member2.setTeam(team);
            member2.setAge(251);
            member2.setMemberType(MemberType.User);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUserName("최승호3");
            member3.setTeam(team1);
            member3.setAge(251);
            member3.setMemberType(MemberType.User);
            em.persist(member3);

            em.flush();
            em.clear();

            String query = "select t from Team t join fetch t.members";

            List<Team> resultList = em.createQuery(query, Team.class)
                    .getResultList();

            for (Team team33 : resultList) {
                System.out.println("team= "+ team33.getName()+"||members " + team33.getMembers().size());
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
