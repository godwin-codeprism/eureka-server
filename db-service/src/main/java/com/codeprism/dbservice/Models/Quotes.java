package com.codeprism.dbservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Quotes {

  @Getter @Setter
  private String username;

  @Getter @Setter
  private List<String> quotes;

}
