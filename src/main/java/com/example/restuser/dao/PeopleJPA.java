package com.example.restuser.dao;

import com.example.restuser.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface PeopleJPA extends JpaRepository<People, Integer> {
}
