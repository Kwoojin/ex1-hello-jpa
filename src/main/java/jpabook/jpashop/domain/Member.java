package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SequenceGenerator(
        name="member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1, allocationSize = 50   // 기본값이지만 명시해둠
)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    /**
     * 실제 환경에서는 Member 로부터 Order 는 좋지 못한 접근
     * Order 로부터 memberId 통해 충분히 주문 목록 조회 가능
     */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
