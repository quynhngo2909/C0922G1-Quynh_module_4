package com.ss08.validation_registration_form.repository;

import com.ss08.validation_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findUserByFirstNameIsContaining(String firstName, Pageable pageable);
}
