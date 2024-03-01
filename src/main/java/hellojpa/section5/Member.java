package hellojpa.section5;

import jakarta.persistence.*;

@Entity(name="MEMBER5")
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String userName;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    //member입장에서는 many고 team입장에서는 원이다.
    // 지연 로딩 즉 member 클래스만 DB에서 조회
    //@ManyToOne(fetch = FetchType.LAZY)

    //즉시 로딩
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TEAM_ID")
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
