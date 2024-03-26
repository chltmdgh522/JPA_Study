package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

//@Entity
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)
//@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "MEMBER_SEQ_GENERATOR") //table, identity, sequence 방언에 따라 선택
    private Long id;

    @Column(name = "name")
    // nullable 널값 유무
    // insertable/updateable 등록변경 가능 여부
    // columnDefinition 은 컬럼을 직접 정의 ex) varchar(100) default 'empty'

    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) //String 필수!!
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    @Transient // DB랑 매핑맺지 않겠다. 즉 무시
    private int temp;
    public Member(){

    } //Jpa는 내부적으로 리플렉션이나 이런것들을 쓰기 때문에 동적으로 객체를 생성해야함


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
