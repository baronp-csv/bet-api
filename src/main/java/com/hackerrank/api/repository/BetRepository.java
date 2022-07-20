package com.hackerrank.api.repository;

import com.hackerrank.api.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
  
}
