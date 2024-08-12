package com.ayupov.Bank.Login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayupov.Bank.Application;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private LoginService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody RequestUser user, HttpSession session) {
        log.info("add " + user.toString());
        LoginForm newUser = new LoginForm();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userService.addUser(newUser);
    }

    @GetMapping("/get")
    public int loginUser(@RequestParam String email, @RequestParam String password, HttpServletRequest request, HttpSession session) 
    {
        log.info("login " + email + " " + password);
        boolean ret = userService.loginUser(email, password);
        if(ret)
        {
            session.setAttribute("email", email);
            return 200;
        }
        else
        {
            session.invalidate();
            return 404;
        }
    }

    @GetMapping("/logout")
    public boolean logoutUser(HttpServletRequest request) {
        log.info("logout");
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
        log.info("check");
        return (request.getSession(false) != null);
    }
}