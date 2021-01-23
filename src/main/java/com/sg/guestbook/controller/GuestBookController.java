package com.sg.guestbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestBookController {

    @GetMapping("/userComments")
    public String getAllUserComments(){
        return "Got It";
    }
}
