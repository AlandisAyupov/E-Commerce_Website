package com.ayupov.Bank.user;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    //TODO:add user implementation, insert into database,
    int addUser(User user)
    {
        String query = "INSERT INTO USERS VALUES ('" + user.getEmail() + "'," + "'" + user.getPassword() + "');";
        return 200;
    }

    List<User> getUsers()
    {
        return new ArrayList<User>();
    }   

    User getUser(String email)
    {
        return new User();
    }

    void updateUser(String email, User user)
    {
        return;
    }

    void deleteUser(String email)
    {
        return;
    }

    void updateName(String email, UserDTO userDTO)
    {
        return;
    }
}
