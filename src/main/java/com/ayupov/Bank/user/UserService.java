package com.ayupov.Bank.user;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(String email);

    void updateUser(String email, User user);

    void deleteUser(String email);

    void updateName(String email, UserDTO userDTO);
}
