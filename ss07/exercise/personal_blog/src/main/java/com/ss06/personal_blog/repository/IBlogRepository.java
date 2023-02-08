package com.ss06.personal_blog.repository;

import com.ss06.personal_blog.model.Blog;
import com.ss06.personal_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, String> {
    @Query(value = "select * from blog where name like :name", nativeQuery = true)
    List<Blog> search(@Param("name") String name);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
    Page<Blog> findByCategory(Category category, Pageable pageable);
}
