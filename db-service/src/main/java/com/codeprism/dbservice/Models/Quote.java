package com.codeprism.dbservice.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "quotes", catalog = "stocks")
@NoArgsConstructor
public class Quote {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  @Getter @Setter
  private Integer id;

  @Column(name="username")
  @Getter @Setter
  public String username;

  @Column(name="quote")
  @Getter @Setter
  private String quote;

  public Quote(String userName, String quote) {
    this.username = userName;
    this.quote = quote;
  }
}
