package com.example.blogsystem.Service;


import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }



    public void UpdateCategory(Integer id ,Category category) {
        Category c= categoryRepository.findCategoryById(id);

        if(c==null) {
            throw new RuntimeException("Category not found");
        }

        c.setName(category.getName());
        categoryRepository.save(c);
    }


    public void deleteCategory(Integer id) {
        Category c= categoryRepository.findCategoryById(id);
        if(c==null) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.delete(c);
    }

   // get category by name
   public Category SearchCategoryByName(String name) {
        Category category=categoryRepository.searchForCategoryByName(name);

        if(category==null) {
            throw new RuntimeException("Category not found");
        }
        return category;
   }



}
