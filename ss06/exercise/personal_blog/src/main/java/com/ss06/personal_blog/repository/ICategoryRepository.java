package com.ss06.personal_blog.repository;

import com.ss06.personal_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category, String> {
}
