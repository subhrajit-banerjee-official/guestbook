package com.sg.guestbook.controller;

import com.sg.guestbook.model.UserComment;
import com.sg.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService gbs;

    @GetMapping("/userComments")
    public List<UserComment> getAllUserComments(){
        List<UserComment> userComments = gbs.getAllUserComments();
        return userComments;
    }
}
