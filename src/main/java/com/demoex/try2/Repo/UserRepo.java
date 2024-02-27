package com.demoex.try2.Repo;

import com.demoex.try2.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepo extends JpaRepository<User ,Long> {
    User findByUsername(String username);

}
