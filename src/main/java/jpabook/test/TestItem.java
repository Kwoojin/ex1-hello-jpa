package jpabook.test;

import javax.persistence.*;

/**
 * SingleTable & Join
 * Join 전략을 기본으로 생각하고,
 * 트레이드오프를 고려하여 선택
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class TestItem {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
