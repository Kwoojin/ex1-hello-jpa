package jpabook.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class TestLocker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
