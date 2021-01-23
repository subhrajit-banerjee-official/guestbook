package com.sg.guestbook.repository;

import com.sg.guestbook.model.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestBookRepository extends JpaRepository<UserComment, Integer> {
}
