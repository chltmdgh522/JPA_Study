package hellojpa;

import hellojpa.section9.Address;
import hellojpa.section9.AddressEntity;
import hellojpa.section9.Member;
import hellojpa.section9.Period;
import jakarta.persistence.*;


public class JpaMain {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member=new Member();
            member.setUsername("최승호");
            member.setHoneAddress(new Address("서울","문화의거리","2000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("햄버거");

            member.getAddressHistory().add(new AddressEntity("인천","문화의거리","2000"));
            member.getAddressHistory().add(new AddressEntity("대구","문화의거리","2000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("==========================");
            Member findMember = em.find(Member.class, member.getId()); //컬렉션들은 지연로딩만 됨

            //임베디드
            // findMember.getHoneAddress().setCity("뉴서울");
            Address a = findMember.getHoneAddress();
            findMember.setHoneAddress(new Address("뉴서울", a.getStreet(), a.getZipcode())); // 새로 갈아끼워야됨

            //String Set
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("김치찌개");

            //주소 List
            //findMember.getAddressHistory().remove(new Address("인천","문화의거리","2000"));
            //equals 구현되어 있엉댜됨

            // findMember.getAddressHistory().add(new Address("부평","문화의거리","2000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
