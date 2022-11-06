package com.example.restuser.services;

import com.example.restuser.dao.UserDtoDao;
import com.example.restuser.models.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDtoDao userDtoDao;


    @Autowired
    public UserService(UserDtoDao userDtoDao) {
        this.userDtoDao = userDtoDao;

    }

    public UserDto getUserById(Long id){
        return userDtoDao.getUserById(id);

    }

}
