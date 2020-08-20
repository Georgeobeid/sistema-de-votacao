package com.georgeobeid.sistemadevotacao.service;

import com.georgeobeid.sistemadevotacao.model.User;

import java.util.Optional;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    Optional<User> findById(Long userId);
}
