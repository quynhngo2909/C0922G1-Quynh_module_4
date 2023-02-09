package com.ss08.validation_registration_form.service.impl;

import com.ss08.validation_registration_form.model.User;
import com.ss08.validation_registration_form.repository.IUserRepository;
import com.ss08.validation_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> findUserByFirstNameIsContaining(String firstName, Pageable pageable) {
        return userRepository.findUserByFirstNameIsContaining(firstName, pageable);
    }
}
