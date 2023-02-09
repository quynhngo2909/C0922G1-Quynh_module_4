package com.ss08.validation_registration_form.service;

import com.ss08.validation_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService extends  IGeneralService<User>{
    Page<User> findUserByFirstNameIsContaining(String firstName, Pageable pageable);
}
