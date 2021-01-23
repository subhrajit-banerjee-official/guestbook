package com.sg.guestbook.it;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GuestBookIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_GetAllUserComments() throws Exception {
        mockMvc.perform(get("/userComments"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$").value("Application Available"));
    }
}
