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

            //String query = "select m.userName, 'HELLO', TRUE from Member m "
            //      + "where m.memberType=hellojpa.section10.MemberType.Admin";
            String query = "select m.userName, 'HELLO', TRUE from Member m "
                    + "where m.memberType=:userType";
            List<Object[]> result = em.createQuery(query)
                    .setParameter("userType",MemberType.User)
                    .getResultList();

            for (Object[] objects : result) {
                System.out.println(objects[1]);
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
