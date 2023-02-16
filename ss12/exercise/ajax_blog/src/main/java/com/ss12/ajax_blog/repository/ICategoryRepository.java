package com.ss12.ajax_blog.repository;

import com.ss12.ajax_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, String> {
}
