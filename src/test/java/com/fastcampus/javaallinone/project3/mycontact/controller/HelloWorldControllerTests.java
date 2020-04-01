package com.fastcampus.javaallinone.project3.mycontact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTests {

    @Autowired
    private HelloWorldController helloWorldController;

    private MockMvc mvc;

    @Test
    void helloWorld(){
//        System.out.println("test");
        System.out.println(helloWorldController.helloWorld());
        assertThat(helloWorldController.helloWorld()).isEqualTo("helloWorld");
    }

    @Test
    void mockMvcTest() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
        mvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("helloWorld"));
    }
}
