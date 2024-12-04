package com.ayupov.bank.User;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayupov.bank.Application;

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
