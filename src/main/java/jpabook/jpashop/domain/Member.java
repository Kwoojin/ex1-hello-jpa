package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
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
