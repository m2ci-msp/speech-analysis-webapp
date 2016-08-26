package com.speechanalysis.security.service;

import com.speechanalysis.model.User;

/**
 * Created by plam on 09/08/16.
 */


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}