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

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member=new Member();
            member.setUserName("Member1");
            member.setTeam(team);
            em.persist(member);

            team.getMembers().add(member); // 편의 메소드로 생략 가능

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();
            //이시점에 쿼리가 또 날라감 member 쿼리 fc 없으면 안됨
            //왜냐하면 영속성 컨텟흐트에 1차캐시로 저들이 저장되는데 members의 대한 정보가 없잔슴
            //양방향일때는 양쪽에 다 세팅을 하자.

            for (Member m : members) {
                System.out.println(m.getUserName());
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
