package com.hackerrank.api.service;

import com.hackerrank.api.model.Bet;
import java.util.List;

public interface BetService {
  List<Bet> getAllBet();

  Bet getBetById(Long id);
}
