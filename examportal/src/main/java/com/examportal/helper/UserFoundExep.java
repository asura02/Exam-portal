package com.examportal.helper;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserFoundExep extends Exception {

  public  UserFoundExep(){
      super("User with this user");
  }

  public UserFoundExep(String msg){super (msg);}

}
