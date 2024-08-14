package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentById(Integer id);

    List<Comment> findAllByPostId(Integer postId);//get all comment for one post by post_id

    @Query("select c from Comment c where c.userId=?1 ")// get all comments of one user
    List<Comment> getAllCommentByUserId(Integer authorId);
}
