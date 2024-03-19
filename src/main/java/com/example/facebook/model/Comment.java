package com.example.facebook.model;

import lombok.Data;

@Data
public class Comment {

    private String accountId;
    private String content;
    private String postId;
    private String commentId;
}
