package com.hackerrank.api.service.impl;

import com.hackerrank.api.model.Bet;
import com.hackerrank.api.repository.BetRepository;
import com.hackerrank.api.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultBetService implements BetService {
	
  private final BetRepository betRepository;

  @Autowired
  DefaultBetService(BetRepository betRepository) {
    this.betRepository = betRepository;
  }

  @Override
  public List<Bet> getAllBet() {
	 System.out.println("DefaultBetService::getAllBet");
    return betRepository.findAll();
  }

  @Override
  public Bet getBetById(Long id) {
    return betRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Bet with ID not found"));
  }
}
