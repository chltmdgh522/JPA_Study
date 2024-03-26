package hellojpa.section7;

import jakarta.persistence.*;

//@Entity
// 중복되는 속성들을 다 하위로 보냄 즉 item 테이블 d없음 근데 쿼리 em.find 할때 union해서 다 뒤짐
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// 이거 안쓰면 상속받은 애들 다 한테이블로 추가됨 즉 상속으로 나뉘게 해주는거 innerjoin
//@Inheritance(strategy = InheritanceType.JOINED)
// 다 통일한 단일 테이블 추가로 discrim 없어도 dtype 생김
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn  // 상속받은 애들 테이블이름들 뜨게해주는 컬럼 신기하당 Dtype 이름 변경 가능 근데 관례
public abstract class Item  {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
