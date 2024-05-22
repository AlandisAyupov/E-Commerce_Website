package com.ayupov.Bank.user;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "users")
public class User {
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
}
