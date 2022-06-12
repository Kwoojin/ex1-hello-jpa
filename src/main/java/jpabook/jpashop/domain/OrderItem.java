package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(
        name="orderItem_seq_generator",
        sequenceName = "orderItem_seq",
        initialValue = 1, allocationSize = 50
)
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_seq_generator")
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_orderItem_to_order"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_orderItem_to_item"))
    private Item item;

    @Column(name = "order_price")
    private int orderPrice;
    private int count;
}
