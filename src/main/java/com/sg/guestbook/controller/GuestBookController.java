package com.sg.guestbook.controller;

import com.sg.guestbook.model.UserComment;
import com.sg.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService gbs;

    @GetMapping("/userComments")
    public List<UserComment> getAllUserComments(){
        return gbs.getAllUserComments();
    }

    @PostMapping("/userComments")
    public UserComment addNewUserComments(@RequestBody UserComment uc){
        UserComment addedUC =  gbs.addUserComment(uc);
        return addedUC;
    }
}
