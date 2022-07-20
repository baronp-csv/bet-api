package com.hackerrank.api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtils {
  private String jwtSecret = "hr_private_secret_code";
  private int jwtExpirationMs = 86400000;

  public String generateJwtToken(Authentication authentication) {
    UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
    return Jwts.builder()
            .setSubject((userPrincipal.getUsername()))
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
	  System.out.println("JwtUtils::validateJwtToken " + authToken);
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      System.out.println("returning True");
      return true;
    } catch (Exception e) {
      System.out.printf("JWT error : {}", e.getMessage());
    }
    return false;
  }
}
