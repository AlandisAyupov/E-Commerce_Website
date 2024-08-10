package com.ayupov.Bank.Login;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ayupov.Bank.Application;

@Service
public class LoginService {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final LoginRepository userRepository;

    public LoginService(LoginRepository userRepository)
    {
        // this keyword refers to current instance
        this.userRepository = userRepository;
    }

    public int addUser(LoginForm user)
    {
        userRepository.save(user);
        return 200;
    }

    public List<LoginForm> getUsers()
    {
        return new ArrayList<>();
    }   

    public boolean loginUser(String email, String password)
    {
        log.info("logging");
        Optional<LoginForm> opt = userRepository.findById(email);
        if(opt.isPresent())
        {
            log.info("user exists");
            LoginForm cmp = opt.get();
            if(cmp.getPassword().equals(password))
            {
                log.info("password matches");
                return opt.isPresent();
            }
        }
        return false;
    }

    void updateUser(String email, LoginForm user)
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
