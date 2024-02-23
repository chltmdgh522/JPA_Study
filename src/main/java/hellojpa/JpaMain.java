package hellojpa;

import hellojpa.section5.Member;
import hellojpa.section5.Team;
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
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUserName("Member1");
            //member.setTeamId(team.getId());
            member.setTeam(team);
            em.persist(member);

            // em.flush();
            // em.close(); //find에서 DB에서 다시 쿼리를 가져오게 할려면

            // Member findMember = em.find(Member.class, member.getId());
            // Long findTeamId=findMember.getTeamId();
            // Team findTeam = em.find(Team.class, findTeamId);

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println(findTeam.getId());

            Team newTeam = em.find(Team.class, 100L); //100번 있다고 가정
            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
