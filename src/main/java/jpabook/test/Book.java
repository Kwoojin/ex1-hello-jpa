package jpabook.test;

import javax.persistence.Entity;

@Entity
public class Book extends TestItem {

    private String author;
    private String isbn;
}
