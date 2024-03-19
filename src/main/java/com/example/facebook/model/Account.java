package com.example.facebook.model;

import lombok.Data;

import java.util.List;

@Data
public class Account {

    private String userName;
    private String email;
    private List<Post> posts;
}
