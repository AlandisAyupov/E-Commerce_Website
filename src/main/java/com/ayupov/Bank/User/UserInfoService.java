package com.ayupov.Bank.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayupov.Bank.Application;
import com.ayupov.Bank.Login.LoginForm;
import com.ayupov.Bank.Login.LoginRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserInfoService {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final UserInfoRepository userRepository;

    public UserInfoService(UserInfoRepository userRepository)
    {
        // this keyword refers to current instance
        this.userRepository = userRepository;
    }

    public int addUser(UserInfo user)
    {
        log.info("add " + user.toString());
        userRepository.save(user);
        return 200;
    }

    public UserInfo getUser(@RequestParam String email)
    {
        log.info("logging");
        Optional<UserInfo> opt = userRepository.findById(email);
        if(opt.isPresent())
        {
            log.info("user exists");
            UserInfo cmp = opt.get();
            return cmp;
        }
        return null;
    }

}
