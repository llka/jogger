package ru.ilka.jogger.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.ilka.jogger.config.TestConfig;
import ru.ilka.jogger.controller.UserController;
import ru.ilka.jogger.repository.UserRepository;
import ru.ilka.jogger.repository.WorkoutRepository;
import ru.ilka.jogger.util.MockEntityFactory;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {TestConfig.class})
//@WebMvcTest(UserController.class)
public class UserServiceTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private WorkoutRepository workoutRepository;
//
//    @Test
//    public void getByIdShouldReturnUser() throws Exception {
//        when(userRepository.findUserById(1L)).thenReturn(MockEntityFactory.Users.bob());
//        this.mockMvc.perform(get("/jogger/users/1"))
//                .andExpect(status().isOk());
//    }
}
