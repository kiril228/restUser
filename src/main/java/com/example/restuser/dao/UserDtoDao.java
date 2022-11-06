package com.example.restuser.dao;

import com.example.restuser.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDtoDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDtoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDto getUserById(Long id) {
        return jdbcTemplate.query("SELECT  name, surname, " +
                        "(YEAR(CURRENT_DATE)-YEAR(`date_of_birth`))-" +
                        "(RIGHT(CURRENT_DATE,5)<RIGHT(`date_of_birth`,5))" +
                        " AS `age` FROM `user` where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(UserDto.class)).stream().findAny().orElse(null);
    }
}
