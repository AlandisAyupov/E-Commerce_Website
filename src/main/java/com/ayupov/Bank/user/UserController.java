package com.ayupov.Bank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayupov.Bank.user.UserService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody requestUser user) {
        //TODO: use userService to add user from params in "user" request object. 
        //TODO: return http status code, 200 if insert is success, 500 otherwise.
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userService.addUser(newUser);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String email) {
        return userService.getUser(email);
    }
}