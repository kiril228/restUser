package com.example.restuser.services;

import com.example.restuser.dao.UserDtoDao;
import com.example.restuser.models.UserDto;
import com.example.restuser.services.UserService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;



public class UserDtoServiceTest {
    private UserService userService;

    @Mock
    private UserDtoDao userDtoDao;

    public UserDtoServiceTest(){
        MockitoAnnotations.initMocks(this);
        this.userService = new UserService(userDtoDao);
    }

    @Test
    public void getUserById_Should_Return_User() {
       UserDto expectedUserDto = new UserDto("test", "test", 1);
       given(userDtoDao.getUserById(1L)).willReturn(expectedUserDto);

       UserDto userDtoExists = userService.getUserById(1L);
        assertSame(expectedUserDto, userDtoExists);
    }


    @Test
    public void getUserById_Should_Return_Null(){
        given(userDtoDao.getUserById(1L)).willReturn(null);
        UserDto userDtoExist = userService.getUserById(1L);
        assertNull(userDtoExist);

    }
}