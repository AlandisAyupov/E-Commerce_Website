package com.ayupov.Bank.User;

import jakarta.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
  @Id
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "firstName", nullable = false)
  private String firstName;
  @Column(name = "lastName", nullable = false)
  private String lastName;
  @Column(name = "address", nullable = false)
  private String address;
  @Column(name = "dateOfBirth", nullable = false)
  private int[] dateOfBirth;
  public String getEmail()
  {
    return this.email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getFirstName()
  {
    return this.firstName;
  }
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public String getLastName()
  {
    return this.lastName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public String getAddress()
  {
    return this.address;
  }
  public void setAddress(String address)
  {
    this.address = address;
  }
  public int[] getDateOfBirth()
  {
    return this.dateOfBirth;
  }
  public void setDateOfBirth(int[] dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  }
}
