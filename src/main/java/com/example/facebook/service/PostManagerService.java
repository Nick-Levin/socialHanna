package com.example.facebook.service;

import com.example.facebook.model.Comment;
import com.example.facebook.model.Post;

public interface PostManagerService {

    Post addPost(Post post, String accountId);
    Post getPost(String postId);
    Post updatePost(Post post);
    void deletePost(String postId, String accountId);

    Comment addComment(Comment comment, String postId, String accountId);
    Comment getComment(String commentId);
    Comment updateComment(Comment comment, String postId, String accountId);
    void deleteComment(String commentId, String postId, String accountId);
}
