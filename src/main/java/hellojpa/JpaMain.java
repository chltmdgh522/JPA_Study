package hellojpa;

import hellojpa.section6.Member;
import hellojpa.section6.Team;
import hellojpa.section7.Movie;
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
            Movie movie=new Movie();
            movie.setDirector("승호얌");
            movie.setActor("승ㅋ");
            movie.setName("승호와 사라지다");
            movie.setPrice(1687896);
            em.persist(movie);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
