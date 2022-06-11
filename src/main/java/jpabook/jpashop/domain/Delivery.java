package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name="delivery_seq_generator",
        sequenceName = "delivery_seq",
        initialValue = 1, allocationSize = 50
)
public class Delivery extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_seq_generator")
    @Column(name = "delivery_id")
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

}
