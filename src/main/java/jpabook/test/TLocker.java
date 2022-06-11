package jpabook.test;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class TLocker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
