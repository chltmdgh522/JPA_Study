package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name="member")
public class Member {

    @Id
    private Long id;

    private String name;

    public Member(){

    } //Jpa는 내부적으로 리플렉션이나 이런것들을 쓰기 때문에 동적으로 객체를 생성해야함

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
