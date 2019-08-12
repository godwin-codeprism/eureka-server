package com.codeprism.dbservice.Repositories;

import com.codeprism.dbservice.Models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuotesRepository extends JpaRepository<Quote, Integer> {
  public List<Quote> findByUsername(String username);
  public List<Quote>  findByUsernameAndQuote(String username, String quote);
}