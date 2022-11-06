package com.example.restuser.dao;
import static org.junit.Assert.*;

import com.example.restuser.models.User;
import com.example.restuser.models.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoDaoTest {

    @Autowired
    private UserDtoDao userDtoDao;

   @Autowired
   private UserDao userDao;

   @Before
   public void before(){
       userDao.deleteAll();

   }

    @Test
    public void getUserById_Should_Return_User() {
        UserDto expectedUserDto = new UserDto("test", "test", 22);
        User user = new User(1L, "test", "test", LocalDate.of(2000, 01, 01));
        userDao.addUser(user);
        UserDto userDtoExists = userDtoDao.getUserById(user.getId());

        assertEquals(expectedUserDto, userDtoExists);


    }

    @Test
    public void getUserById_Should_Return_Null(){
       UserDto userDtoExists = userDtoDao.getUserById(1L);
       assertNull(userDtoExists);



    }



}