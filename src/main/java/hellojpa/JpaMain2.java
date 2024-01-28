//package hellojpa;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//import java.util.List;
//
//public class JpaMain2 {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        //code
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            //비영속
////            Member member= new Member();
////            member.setName("승호");
////            member.setId(101L);
//
//            //영속 상태 DB에 저장되는게 아님 영속성 컨텍스트에 저장
//            // em.persist(member);
//
//            //em.detach(member); //영속성 컨텍스트에서 분리 즉 준영속 상태
//
//            Member findMember = em.find(Member.class, 150L);
//            Member findMember1 = em.find(Member.class, 150L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember1.getId() = " + findMember1.getId());
//            tx.commit(); //이떄 DB에 쿼리 날려서 저장함
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
//        }
//        emf.close();
//    }
//}
