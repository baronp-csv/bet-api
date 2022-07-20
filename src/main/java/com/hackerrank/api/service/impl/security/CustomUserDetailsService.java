package com.hackerrank.api.service.impl.security;

import com.hackerrank.api.model.security.User;
import com.hackerrank.api.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

    User existingUser = userRepository.findByUsername(user).orElseThrow(() ->
            new UsernameNotFoundException("User not found"));

    return new org.springframework.security.core.userdetails.User(existingUser.getUsername(), existingUser.getPassword(), new ArrayList<>());


  }

}
