package com.examportal.service;

import com.examportal.model.User;
import com.examportal.model.UserRole;

import java.util.Set;

public interface UserService {

    //create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public  void deleteUser(Long userId);

    //update user by id
    public  User updateUser(Long userId,User user) throws Exception;




}
