package com.ayupov.Bank.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
public class User {
  @Id
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
  public String getEmail()
  {
    return this.email;
  }
  public String getPassword()
  {
    return this.password;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
}
