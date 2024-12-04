package com.ayupov.bank.User;

public class RequestUserInfo {
    String email;
    String firstName;
    String lastName;
    int type;
    String address;
    int[] dateOfBirth;
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
    public int getType()
    {
      return this.type;
    }
    public void setType(int type)
    {
      this.type = type;
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
    @Override
    public String toString()
    {
        return this.email + " " + this.firstName + " " + this.lastName + " " + this.address + " " + this.dateOfBirth;
    }
}
