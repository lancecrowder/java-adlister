package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    User findByPassword(String password);

    Long insert(User user);
}
