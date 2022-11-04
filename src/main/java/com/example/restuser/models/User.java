package com.example.restuser.models;

import javax.persistence.*;


public class User {


    private Long id;


    private String name;


    private String surname;

    private Integer age;

    public User() {
    }

    public User(String name, String surname, int dateOfBirth, int age) {
        this.name = name;
        this.surname = surname;

        this.age = age;
    }

    public User(String name, String surname, int dateOfBirth) {
        this.name = name;
        this.surname = surname;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
