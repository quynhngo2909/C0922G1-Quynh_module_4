package com.ss11.restfull_blog_management.respository;

import com.ss11.restfull_blog_management.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, String> {

}
