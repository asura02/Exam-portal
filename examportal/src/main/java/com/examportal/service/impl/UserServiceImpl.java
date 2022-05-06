package com.examportal.service.impl;

import com.examportal.helper.UserFoundExep;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repo.RoleRepo;
import com.examportal.repo.UserRepo;
import com.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

       User local =  this.userRepo.findByUsername(user.getUsername());
       if(local!=null){
           System.out.println("User is already there");
           throw new UserFoundExep("User already present");
       }else {
           //create user
           for (UserRole ur: userRoles ){
               roleRepo.save(ur.getRole());
           }

           user.getUserRoles().addAll(userRoles);
            local = this.userRepo.save(user);


       }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
      return   this.userRepo.findByUsername(username);
    }

    //delete user
    @Override
    public void deleteUser(Long userId) {
        this.userRepo.deleteById(userId);
    }

    //update user
    @Override
    public User updateUser(Long userId,User user) throws Exception {
        user.setId(userId);

       return   this.userRepo.save(user);

    }

}
