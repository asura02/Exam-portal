package com.examportal.repo;

import com.examportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    public User findByUsername(String name);

}
