package com.ayupov.Bank.user;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    void addUser(User user)
    {
        return;
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
