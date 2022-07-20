package com.hackerrank.api.controller;

import com.hackerrank.api.model.Bet;
import com.hackerrank.api.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/bet")
public class BetController {
  private final BetService betService;

  @Autowired
  public BetController(BetService betService) {
    this.betService = betService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Bet> getAllBet() {
	  System.out.println("BetController::getAllBet");
    return betService.getAllBet();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Bet getVulnerabilityById(@PathVariable Long id) {
	  System.out.println("BetController::getVulnerabilityById");
    return betService.getBetById(id);
  }
}
