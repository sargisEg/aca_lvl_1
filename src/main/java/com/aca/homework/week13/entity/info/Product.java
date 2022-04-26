package com.aca.homework.week13.entity.info;

import com.aca.homework.week13.entity.info.annotations.Column;
import com.aca.homework.week13.entity.info.annotations.Entity;
import com.aca.homework.week13.entity.info.annotations.Id;
import com.aca.homework.week13.entity.info.annotations.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    private Long id;

    @Column(name="NAME")
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}