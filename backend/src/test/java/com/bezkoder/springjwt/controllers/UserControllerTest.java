package com.bezkoder.springjwt.controllers;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void allAccess() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("all"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Public Content."));
    }

    @Test
    void userAccess() {
    }

    @Test
    void adminAccess() {
    }
}