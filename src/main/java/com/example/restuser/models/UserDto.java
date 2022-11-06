package com.example.restuser.models;


import java.util.Objects;

/**
 * @author Kirill Nizhnik
 * @UserDto - for transaction with specific fields
 */
public class UserDto {


    private String name;


    private String surname;

    private Integer age;

    public UserDto() {
    }

    public UserDto(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) && Objects.equals(surname, userDto.surname) && Objects.equals(age, userDto.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}


