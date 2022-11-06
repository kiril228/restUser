package com.example.restuser.controllers;
import com.example.restuser.dao.UserDao;
import com.example.restuser.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserDao userDao;

    @Before
    public void before(){
        userDao.deleteAll();
    }

    @Test
    public void getExistsUser_Not_Null_Result()  throws Exception{
        User user = new User(1L, "test", "test", LocalDate.of(2000, 1, 1));
        userDao.addUser(user);
        this.mockMvc.perform(get("/api/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"name\": \"test\",\n" +
                        "  \"surname\": \"test\",\n" +
                        "  \"age\": 22\n" +
                        "}", true)).andReturn();
    }

    @Test
    public void getNotExistUser_Null_Result() throws Exception {
        this.mockMvc.perform(get("/api/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();
        ;
    }


}