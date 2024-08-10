package com.ayupov.Bank.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayupov.Bank.Application;
import com.ayupov.Bank.User.UserInfo;
import com.ayupov.Bank.User.UserInfoService;
import com.ayupov.Bank.User.RequestUserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class UserInfoController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserInfoService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody RequestUserInfo user) {
        log.info("add " + user.toString());
        UserInfo newUser = new UserInfo();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAddress(user.getAddress());
        newUser.setDateOfBirth(user.getDateOfBirth());
        return userService.addUser(newUser);
    }

    @GetMapping("/get")
    public UserInfo getUser(@RequestParam String email) 
    {
        log.info("get " + email);
        return userService.getUser(email);
    }
}