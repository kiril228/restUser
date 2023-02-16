package com.example.restuser.controllers;

import com.example.restuser.models.People;
import com.example.restuser.models.UserDto;
import com.example.restuser.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/people")
public class PeopleRestController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleRestController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @ResponseBody
    @GetMapping("/")
    public List<People> getUserById(){
        return peopleService.getPeople();
    }



}
