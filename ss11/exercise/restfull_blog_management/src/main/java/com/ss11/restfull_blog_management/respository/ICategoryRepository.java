package com.ss11.restfull_blog_management.respository;

import com.ss11.restfull_blog_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
    Category findByNameContaining (String name);
}
