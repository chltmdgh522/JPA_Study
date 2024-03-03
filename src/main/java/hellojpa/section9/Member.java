package hellojpa.section9;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "MEMBER9")
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Embedded
    private Period wordPeriod;

    @Embedded
    private Address honeAddress;

    @Embedded //중복 주소 정의
    @AttributeOverrides({@AttributeOverride(name = "city",
            column = @Column(name = "work_city")), @AttributeOverride(name = "street",
            column = @Column(name = "work_street")), @AttributeOverride(name = "zipcode",
            column = @Column(name = "work_zipcode"))
    })
    private Address workAddress;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWordPeriod() {
        return wordPeriod;
    }

    public void setWordPeriod(Period wordPeriod) {
        this.wordPeriod = wordPeriod;
    }

    public Address getHoneAddress() {
        return honeAddress;
    }

    public void setHoneAddress(Address honeAddress) {
        this.honeAddress = honeAddress;
    }
}
