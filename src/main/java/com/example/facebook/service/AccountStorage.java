package com.example.facebook.service;

import com.example.facebook.model.Account;
import com.example.facebook.model.Comment;
import com.example.facebook.model.Post;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AccountStorage {

    @Getter
    private List<Account> accounts;

    public AccountStorage() {
        this.accounts = new ArrayList<>();
        initAccounts(accounts);
    }

    private Set<String> initIds() {
        Set<String> accountIds = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            accountIds.add(RandomStringUtils.randomAlphabetic(7,10));
        }
        return accountIds;
    }

    private void initAccounts(List<Account> accounts) {
        Set<String> accountIds = initIds();
        accountIds.forEach(accId -> {
            Account account = new Account();
            account.setEmail(accId);
            account.setUserName(RandomStringUtils.randomAlphabetic(4,6));
            account.setPosts(initPosts(accountIds.stream().toList()));
            accounts.add(account);
        });
    }

    private List<Post> initPosts(List<String> accountIds) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Post post = new Post();
            String postId = UUID.randomUUID().toString();
            post.setId(postId);
            post.setTitle("title");
            post.setContent("content");
            post.setComments(initComments(postId, accountIds));
            posts.add(post);
        }
        return posts;
    }

    private List<Comment> initComments(String postId, List<String> accountIds) {
        List<Comment> comments = new ArrayList<>();

        for (String accountId : accountIds) {
            Comment comment = new Comment();
            comment.setCommentId("comment");
            comment.setPostId(postId);
            comment.setAccountId(accountId);
            comment.setCommentId(UUID.randomUUID().toString());
            comments.add(comment);
        }

        return comments;
    }
}
