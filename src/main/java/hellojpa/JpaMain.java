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
            member.setMemberType(MemberType.User);

            team.getMembers().add(member);

            em.persist(member);
            em.flush();
            em.clear();

            String query = "select size(t.members) from Team t";

            List<String> resultList = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : resultList) {
                System.out.println(s);
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
