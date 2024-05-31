package com.ayupov.Bank.user;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {
    private UserRepository userRepository;
    //TODO:add user implementation, insert into database,
    int addUser(User user)
    {
        String query = "INSERT INTO USERS VALUES ('" + user.getEmail() + "'," + "'" + user.getPassword() + "');";
        userRepository.save(user);
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
