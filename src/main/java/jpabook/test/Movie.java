package jpabook.test;

import javax.persistence.Entity;

@Entity
public class Movie extends TestItem {

    private String director;
    private String actor;
}
