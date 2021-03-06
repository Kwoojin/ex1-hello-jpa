package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name="delivery_seq_generator",
        sequenceName = "delivery_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
public class Delivery extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_seq_generator")
    @Column(name = "delivery_id")
    private Long id;

    @Embedded
    private Address address;

    private DeliveryStatus status;

}
