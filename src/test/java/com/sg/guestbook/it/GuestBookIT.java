package com.sg.guestbook.it;


import com.sg.guestbook.model.UserComment;
import com.sg.guestbook.repository.GuestBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GuestBookIT {

    @Autowired
    MockMvc mockMvc;

    List<UserComment> dummyUserComments;

    @MockBean
    GuestBookRepository repo;

    @BeforeEach
    void setup(){
        this.dummyUserComments = new ArrayList<>();
        this.dummyUserComments.add(UserComment.builder()
                .name("Gokul")
                .comment("This is the worst website I ever visited")
                .build());
        this.dummyUserComments.add(UserComment.builder()
                .name("Subhro")
                .comment("Gokul is always right")
                .build());
    }

    @Test
    void test_GetAllUserComments() throws Exception {
        Mockito.when(repo.findAll()).thenReturn(dummyUserComments);
        mockMvc.perform(get("/userComments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("Gokul"))
                .andExpect(jsonPath("[0].comment").value("This is the worst website I ever visited"))
                .andExpect(jsonPath("[1].name").value("Subhro"))
                .andExpect(jsonPath("[1].comment").value("Gokul is always right"));
    }

    @Test
    void test_AddNewUserComments() throws Exception {
        Mockito.when(repo.findAll()).thenReturn(dummyUserComments);
        mockMvc.perform(post("/userComments"))
                .andExpect(status().isOk());

    }
}
