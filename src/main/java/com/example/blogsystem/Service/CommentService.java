package com.example.blogsystem.Service;


import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CommentRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userReposiroty;

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }


    public void addComment(Comment comment) {
        User user = userReposiroty.findUserById(comment.getUserId());
        Post post = postRepository.findPostById(comment.getPostId());

        if (user==null) {
            throw new RuntimeException("User with ID: " + comment.getUserId() + " not found");
        }

        if (post==null) {
            throw new RuntimeException("Post with ID: " + comment.getPostId() + " not found");
        }
        commentRepository.save(comment);
    }


    public void UpdateComment(Integer id, Comment comment) {
        Comment c = commentRepository.findCommentById(id);

        if (c == null) {
            throw new RuntimeException("Comment not found");
        }
        c.setContent(comment.getContent());
        commentRepository.save(c);

    }

    public void deleteComment(Integer id) {
        Comment c = commentRepository.findCommentById(id);

        if (c == null) {
            throw new RuntimeException("Comment with ID " + id + " not found");
        }
        commentRepository.delete(c);
    }


    //get all comment for one post by post id
    public List<Comment> getAllCommentsForPost(Integer postId) {
        List<Comment> list= commentRepository.findAllByPostId(postId);

        if(list.isEmpty()){
           throw new RuntimeException("No comments found");
        }
        return list;
    }


    // get all comments of one user
    public List<Comment> getAllCommentsForUser(Integer userId) {
        if (commentRepository.getAllCommentByUserId(userId) == null) {
            throw new RuntimeException("User with ID: " + userId + " not found");
        }
        return commentRepository.getAllCommentByUserId(userId);
    }

}
