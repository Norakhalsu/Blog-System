package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryById(int id);

    // category by name
    @Query("select  c from Category c where c.name=?1")
    Category searchForCategoryByName(String categoryName);


}
