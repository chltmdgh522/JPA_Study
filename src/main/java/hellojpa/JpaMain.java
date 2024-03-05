package hellojpa;

import hellojpa.section10.Address;
import hellojpa.section10.Member;
import hellojpa.section10.MemberDto;
import hellojpa.section10.Order;
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
            Member member =new Member();
            member.setUserName("최승호");
            member.setAge(25);
            em.persist(member);
            em.flush();
            em.clear();

            // List<Address> resultList = em.createQuery("select o.address from Order o", Address.class).getResultList();

            List resultList = em.createQuery("select m.userName, m.age from Member m").getResultList();
            Object o = resultList.get(0);
            Object[] result = (Object[]) o;
            System.out.println(result[0]); //userName;
            System.out.println(result[1]); //age


            List<Object[]> resultList1 = em.createQuery("select m.userName, m.age from Member m").getResultList();

            List<MemberDto> resultList2 = em.createQuery("select new hellojpa.section10.MemberDto(m.userName, m.age) from Member m", MemberDto.class)
                    .getResultList();

            MemberDto memberDto = resultList2.get(0);
            System.out.println(memberDto.getAge());
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //엔티티 매니저가 커넥션을 갖고 있어서 닫아줘야됨
        }
        emf.close();
    }
}
