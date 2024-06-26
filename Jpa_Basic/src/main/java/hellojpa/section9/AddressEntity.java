package hellojpa.section9;

import jakarta.persistence.*;

//@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
    private Address address;

    public AddressEntity(String city, String street, String zip) {
        this.address=new Address(city,street,zip);
    }

    public AddressEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
