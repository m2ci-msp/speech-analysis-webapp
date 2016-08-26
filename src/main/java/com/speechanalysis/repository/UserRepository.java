package com.speechanalysis.repository;

import com.speechanalysis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by plam on 09/08/16.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
