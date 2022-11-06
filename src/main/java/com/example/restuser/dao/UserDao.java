package com.example.restuser.dao;

import com.example.restuser.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user){
        jdbcTemplate.update("INSERT INTO user (id, name, surname, date_of_birth) values (?,  ?, ?,?)",
                user.getId(), user.getName(), user.getSurname(), user.getDateOfBirth());
    }

    public void  deleteAll(){
        jdbcTemplate.update("DELETE FROM user");
    }
}
