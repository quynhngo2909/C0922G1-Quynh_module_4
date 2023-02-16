package com.ss12.ajax_blog.repository;

import com.ss12.ajax_blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, String> {
}
