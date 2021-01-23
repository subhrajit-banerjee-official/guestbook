package com.sg.guestbook.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class UserComment {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String comment;
}
