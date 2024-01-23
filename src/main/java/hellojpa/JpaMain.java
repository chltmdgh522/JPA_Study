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
//            Member member = new Member();
//            member.setId(4L);
//            member.setName("helloB");
//            em.persist(member);

            Member findMember = em.find(Member.class, 3L); //조회
            findMember.setName("tmdgh이"); //여기서 트랜잭션 커밋하기 직전에 업데이트 쿼리를 날림

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(8)
                    .getResultList(); // DB에 따라서 저 퍼스트와 맥스가 DB에 따라 다른 sql 생성 리미트(mysql) vs 로우넘(오라클)
            //전체조회 대상은 테이블이 아닌 객체임


//            em.remove(findMember); //삭제

            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
