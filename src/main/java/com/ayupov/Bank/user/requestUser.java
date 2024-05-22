package com.ayupov.Bank.user;

public class requestUser {
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
    public String setEmail()
    {
        return this.email;
    }
    public String setPassword()
    {
        return this.password;
    }
    @Override
    public String toString()
    {
        return this.email + " " + this.password;
    }
}
