package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@SequenceGenerator(
        name="orderItem_seq_generator",
        sequenceName = "orderItem_seq",
        initialValue = 1, allocationSize = 50
)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_seq_generator")
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_orderItem_to_order"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_orderItem_to_item"))
    private Item item;

    @Column(name = "order_price")
    private int orderPrice;
    private int count;
}
