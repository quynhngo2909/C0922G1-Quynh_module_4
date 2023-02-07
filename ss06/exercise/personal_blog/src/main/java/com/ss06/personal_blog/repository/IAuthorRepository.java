package com.ss06.personal_blog.repository;

import com.ss06.personal_blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, String> {
}
