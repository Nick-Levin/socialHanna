package com.example.facebook.model;

import lombok.Data;

import java.util.List;

@Data
public class Post {

    private String title;
    private String content;
    private List<Comment> comments;
    private String id;
}
