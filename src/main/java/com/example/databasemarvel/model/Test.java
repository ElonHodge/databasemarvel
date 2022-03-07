package com.example.databasemarvel.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {


    @Id
    @Column
    private String testId;

    @Column(columnDefinition = "text[]")
    @Type(type = "com.example.databasemarvel.CustomStringArrayType")
    private String[] items;
}
