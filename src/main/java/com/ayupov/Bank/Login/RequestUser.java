package com.ayupov.Bank.Login;

public class RequestUser {
    String email;
    String password;
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
    @Override
    public String toString()
    {
        return this.email + " " + this.password;
    }
}
