package com.example.restuser.dao;

import com.example.restuser.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import static org.hibernate.loader.Loader.SELECT;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUser(Long id){
        return jdbcTemplate.query("SELECT id, name, surname, (YEAR(CURRENT_DATE)-YEAR(`date_of_birth`))-(RIGHT(CURRENT_DATE,5)<RIGHT(`date_of_birth`,5)) AS `age` FROM `user` where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class)).stream().findAny().orElse(null);
    }
}
