package com.ayupov.Bank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody requestUser user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userService.addUser(newUser);
    }

    @GetMapping("/get")
    public int loginUser(@RequestParam String email, @RequestParam String password) {
        boolean ret = userService.loginUser(email, password);
        if(ret)
            return 200;
        else
            return 404;
    }
}