package net.diyotech.ems.entity;

import jakarta.persistence.*;

@Entity
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;

    @Transient
    private Integer pageCount;
}
