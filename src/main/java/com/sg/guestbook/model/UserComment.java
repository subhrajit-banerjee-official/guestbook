package com.sg.guestbook.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class UserComment {

    @Id
    private String name;
    private String comment;
}
