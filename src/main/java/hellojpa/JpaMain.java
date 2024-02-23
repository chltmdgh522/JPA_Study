package hellojpa;

import hellojpa.section5.Member;
import hellojpa.section5.Team;
import jakarta.persistence.*;


public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member=new Member();
            member.setUserName("Member1");
            // member.setTeamId(team.getId());
            member.setTeam(team);
            em.persist(member);

            //조회
            Member findMember = em.find(Member.class, member.getId());
            // Team findTeamId = em.find(Team.class, team.getId());
            // Team findTeam= em.find(Team.class, findTeamId);
            Team findTeam = findMember.getTeam();

            //수정
            Team newTeam = em.find(Team.class, 100L); //100번이 있다 가정하고
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
