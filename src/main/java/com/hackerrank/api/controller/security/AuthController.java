package com.hackerrank.api.controller.security;

import com.hackerrank.api.model.security.User;
import com.hackerrank.api.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/login/auth")
  public ResponseEntity<String> login(@RequestBody User user) {
      String token = jwtUtils.generateJwtToken(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
              user.getUsername(),user.getPassword())));
      if(token != null) {
    	  return new ResponseEntity<String>(token,HttpStatus.OK);

      }else{
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
      }    

  }
}
