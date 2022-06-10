package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@SequenceGenerator(
        name="order_seq_generator",
        sequenceName = "order_seq",
        initialValue = 1, allocationSize = 50
)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_generator")
    @Column(name = "order_id")
    private Long id;

//    @Column(name = "member_id") //UML 문제
//    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_order_to_member"))
    private Member member;

    @OneToOne
    @JoinColumn(name = "delivery_id", foreignKey = @ForeignKey(name = "fk_order_to_delivery"))
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
