package com.example.blogsystem.Repository;


import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(int id);

    List<Post> findAllByUserId(int id);// get all post by user id

    Post findByTitle(String title);// get post by title

    @Query("select p from Post p where p.publishDate < :date")//get all post before date by date
    List<Post> findAllPostsBeforeDate(@PathVariable("date") LocalDate date);
}
