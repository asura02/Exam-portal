package com.examportal.controller;

import com.examportal.helper.UserFoundExep;
import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UserRole userroles = new UserRole();
        userroles.setUser(user);
        userroles.setRole(role);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userroles);

        return this.userService.createUser(user, roles);

    }

    //getuser
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return  this.userService.getUser(username);
    }

    //deletesuer
    @DeleteMapping("/{userId}")
    public  void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //update user by id
    @PutMapping("/{userId}")
    public  User updateUser(@RequestBody User user,  @PathVariable("userId") Long id) throws Exception {

        return  this.userService.updateUser(id,user);
    }

    //exceptionhandler

//    @ExceptionHandler(UserFoundExep.class)
//    public ResponseEntity<?> exceptionHandler(UserFoundExep ex){return  }


}
