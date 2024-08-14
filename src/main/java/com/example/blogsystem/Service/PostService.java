package com.example.blogsystem.Service;


import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CategoryRepository;
import com.example.blogsystem.Repository.PostRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userReposiroty;
    private final CategoryRepository categoryRepository;

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


    public void addPost(Post post) {
         User u=userReposiroty.findUserById(post.getUserId());
         Category c=categoryRepository.findCategoryById(post.getCategoryId());

               if(u == null || c==null){
                   throw new RuntimeException("User id or Category id not found");
               }
        postRepository.save(post);
    }


    public void UpdatePost(Integer id, Post post) {
        Post p = postRepository.findPostById(id);

        if (p == null) {
            throw new RuntimeException("Post not found");
        }
        p.setCategoryId(post.getCategoryId());
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());

        postRepository.save(p);
    }

   public void deletePost(Integer id) {
        Post p = postRepository.findPostById(id);
        if (p == null) {
            throw new RuntimeException("Post not found");
        }
        postRepository.delete(p);
   }



   // get all post by user id
   public List<Post> getAllPostsByUserId(Integer userId) {
       List<Post> posts = postRepository.findAllByUserId(userId);

       if (posts == null || posts.isEmpty()) {
           throw new RuntimeException("No posts found for user with ID: " + userId);
       }
       return posts;
   }


   //get post by title
    public Post getPostByTitle(String title) {
       Post p=postRepository.findByTitle(title);
       if (p == null) {
           throw new RuntimeException("Post not found");
       }
       return p;
    }



    // get all post before date by date
    public List<Post> getAllPostsBeforeDate(LocalDate date) {
        List<Post> list= postRepository.findAllPostsBeforeDate(date);
        if(list==null || list.isEmpty()){
            throw new RuntimeException("No posts found");
        }
        return list;
    }



}
