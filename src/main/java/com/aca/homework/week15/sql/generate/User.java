package com.aca.homework.week15.sql.generate;

import com.aca.homework.week13.entity.info.annotations.Column;
import com.aca.homework.week13.entity.info.annotations.Table;

@Table(name = "users")
public class User {

    @Column(name = "full_name")
    private final String name;

    @Column(name = "age")
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
