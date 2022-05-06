package com.examportal.controller;

import com.examportal.config.JwtUtil;
import com.examportal.model.JwtRequest;
import com.examportal.model.JwtResponse;
import com.examportal.model.User;
import com.examportal.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    //generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("user not found");
        }

        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
         return  ResponseEntity.ok(new JwtResponse(token));

    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return   ((User) this.userDetailService.loadUserByUsername(principal.getName()));

    }

    private void authenticate(String username,String password) throws Exception {

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


        }catch (DisabledException e){
            throw new Exception("User Disabled"+e.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid Credentials"+e.getMessage());
        }
    }

}
