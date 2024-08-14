package com.example.blogsystem.Controller;


import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {


    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getComment() {
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }


    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody Comment comment , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(201).body("Comment added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@RequestBody Comment comment , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.UpdateComment(id, comment);
        return ResponseEntity.status(201).body("Comment updated successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(201).body("Comment deleted successfully");
    }


    @GetMapping("/all/{postId}")// get all comment for one post by post id
    public ResponseEntity getAllComment(@PathVariable Integer postId) {
        return ResponseEntity.status(200).body(commentService.getAllCommentsForPost(postId));
    }


    @GetMapping("/comments/{userid}")//get all comments of one user
    public ResponseEntity getCommentsForUser(@PathVariable Integer userid) {
        return ResponseEntity.status(200).body(commentService.getAllCommentsForUser(userid));
    }

}
