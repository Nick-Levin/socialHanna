package com.example.facebook.service;

import com.example.facebook.model.Account;
import com.example.facebook.model.Comment;
import com.example.facebook.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostManagerServiceImpl implements PostManagerService {

    private final AccountStorage accountStorage;
    private final AccountManagerService accountManagerService;

    @Override
    public Post addPost(Post post, String accountId) {
        Account findAccount = accountManagerService.getAccount(accountId);
        post.setId(UUID.randomUUID().toString());
        findAccount.getPosts().add(post);
        return post;
    }

    @Override
    public Post getPost(String postId) {
        return accountStorage.getAccounts().stream()
                .map(account -> account.getPosts())
                .flatMap(postList -> postList.stream())
                .filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public void deletePost(String postId, String accountId) {

    }

    @Override
    public Comment addComment(Comment comment, String postId, String accountId) {
        comment.setCommentId(UUID.randomUUID().toString());
        accountStorage.getAccounts().stream()
                .flatMap(account -> account.getPosts().stream())
                .flatMap(post -> post.getComments().stream())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CHANGE2"));
        return null;
    }

    @Override
    public Comment getComment(String commentId) {
        return accountStorage.getAccounts().stream()
                .flatMap(account -> account.getPosts().stream())
                .flatMap(post -> post.getComments().stream())
                .filter(comment -> comment.getCommentId().equals(commentId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Comment updateComment(Comment comment, String postId, String accountId) {
        return null;
    }

    @Override
    public void deleteComment(String commentId, String postId, String accountId) {

    }

}
