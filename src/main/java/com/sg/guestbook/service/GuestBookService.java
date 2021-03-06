package com.sg.guestbook.service;

import com.sg.guestbook.model.UserComment;
import com.sg.guestbook.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepository gbr;

    public List<UserComment> getAllUserComments() {
        return gbr.findAll();
    }

    public UserComment addUserComment(UserComment uc) {
        return gbr.save(uc);
    }
}
