package com.codeprism.dbservice.Controllers;

import com.codeprism.dbservice.Models.Quote;
import com.codeprism.dbservice.Models.Quotes;
import com.codeprism.dbservice.Repositories.QuotesRepository;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log
@RestController
@RequestMapping("rest/db")
public class EndpointsController {

  private QuotesRepository quotesRespository;

  public EndpointsController(QuotesRepository quotesRespository) {
    this.quotesRespository = quotesRespository;
  }

  @GetMapping("/{username}")
  public List<String> getQuotes(@PathVariable("username") final String username) {
    return getQuotesByUsername(username);
  }

  private List<String> getQuotesByUsername(@PathVariable("username") String username) {
    return quotesRespository.findByUsername(username)
        .stream()
        .map(Quote::getQuote)
        .collect(Collectors.toList());
  }

  @PostMapping("/add")
  public List<String> add(@RequestBody final Quotes quotes) {
    quotes.getQuotes()
        .stream()
        .map(quote -> new Quote(quotes.getUsername(), quote))
        .forEach(quote -> quotesRespository.save(quote));

    return getQuotesByUsername(quotes.getUsername());
  }

  @PostMapping("/delete")
  public List<String> delete(@RequestBody final Quotes quotes) {
    quotes.getQuotes()
        .forEach(quote -> {
          quotesRespository.findByUsernameAndQuote(quotes.getUsername(), quote).forEach(quote1 -> {
            quotesRespository.delete(quote1.getId());
          });
        });
    return getQuotesByUsername(quotes.getUsername());
  }

  @PostMapping("/delete/{username}")
  public List<String> deleteUser(@PathVariable("username") String username) {
    quotesRespository.findByUsername(username).forEach(quote -> quotesRespository.delete(quote.getId()));
    return getQuotesByUsername(username);
  }

}
