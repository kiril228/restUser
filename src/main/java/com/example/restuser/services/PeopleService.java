package com.example.restuser.services;

import com.example.restuser.dao.PeopleJPA;
import com.example.restuser.models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    final PeopleJPA peopleJPA;

    public PeopleService(PeopleJPA peopleJPA) {
        this.peopleJPA = peopleJPA;
    }


    public List<People> getPeople(){
        return peopleJPA.findAll();
    }

    public void addPeople(People people){
        peopleJPA.save(people);
    }
}
