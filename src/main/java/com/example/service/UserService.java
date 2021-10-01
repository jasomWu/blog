package com.example.service;

import com.example.entity.User;

/**
 * @author sunwu
 * @since 2021-09-23-18:40
 */
public interface UserService {
    User checkUser(User user);

    User getUserById(Long id);
}
