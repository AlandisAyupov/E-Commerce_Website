package com.ayupov.Bank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody RequestUser user, HttpSession session) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userService.addUser(newUser);
    }

    @GetMapping("/get")
    public int loginUser(@RequestParam String email, @RequestParam String password, HttpServletRequest request, HttpSession session) {
        boolean ret = userService.loginUser(email, password);
        if(ret)
            return 200;
        else
            return 404;
    }

    @GetMapping("/logout")
    public boolean logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);        
        if(session != null) {
            session.invalidate();
            return true;
        }
        else
            return false;
    }

    @GetMapping("/check")
    public boolean checkSession(HttpServletRequest request) {
        return (request.getSession(false) == null);
    }
}