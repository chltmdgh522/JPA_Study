package hellojpa.section6;

import jakarta.persistence.*;

@Entity(name="MEMBER6")
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String userName;

    @ManyToOne // 1대다 양방향 읽기 전용 근데 다대1 방향 쓰자
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
