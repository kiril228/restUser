package com.example.restuser.services;

import com.example.restuser.dao.UserDao;
import com.example.restuser.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDao userDao;


    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;

    }

    public User getUserById(Long id){
        return userDao.getUser(id);

    }

}
