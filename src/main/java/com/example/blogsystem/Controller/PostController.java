package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getCategory() {
        return  ResponseEntity.status(200).body(postService.getAllPost());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.addPost(post);
        return ResponseEntity.status(201).body("post added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.UpdatePost(id, post);
        return ResponseEntity.status(201).body("post updated successfully");
    }

    @DeleteMapping("/delete/{id}")
 public ResponseEntity deleteCategory(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(201).body("post deleted successfully");
    }


    @GetMapping("/post/{userId}")// get all post by user id
    public ResponseEntity getPost(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(postService.getAllPostsByUserId(userId));
    }

    @GetMapping("/title/{title}")//get post by title
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));
    }

    @GetMapping("/date/{date}")//get all post before date by date
    public ResponseEntity getPostByDate(@PathVariable LocalDate date) {
        return ResponseEntity.status(200).body(postService.getAllPostsBeforeDate(date));
    }



}
