package com.example.restuser.models;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;


    @Column(name = "surname")
    private String surname;
}
