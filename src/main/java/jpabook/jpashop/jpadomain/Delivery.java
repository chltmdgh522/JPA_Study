package jpabook.jpashop.jpadomain;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private String street;
    private String zipcode;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliverStatus deliveryStatus;






}
