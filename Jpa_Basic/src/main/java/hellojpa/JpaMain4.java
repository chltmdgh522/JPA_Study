//package hellojpa;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class JpaMain4 {
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
//            Member member1=new Member(200L, "A");
//            em.persist(member1);
//            em.flush(); //강제 쿼리 보내서 DB로 보냄
//            System.out.println("==================");
//
//            tx.commit(); //이떄 DB에 쿼리 날려서 저장함
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
//        }
//        emf.close();
//    }
//}
