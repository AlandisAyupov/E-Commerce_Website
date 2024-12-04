package com.ayupov.Bank;

//USing BDD Mockito 
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ayupov.bank.Login.LoginForm;
import com.ayupov.bank.Login.LoginRepository;
import com.ayupov.bank.Login.LoginService;
 
@ExtendWith(MockitoExtension.class)
 
// Main class
class ControllerTests {
 
    @Mock
    private LoginRepository userRepo;
    //When using Mockito Use @InjectMocks to inject
    //Mocked beans to following class
    @InjectMocks
    private LoginService userService;
 
    @Test 
    void addUser()
    {
        //given
		LoginForm user1 = new LoginForm();
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1dj1jd90");
        given(userRepo.save(user1))
        .willReturn(user1);

        assertThat(userService.addUser(user1)).isEqualTo(200);
    }

    @Test 
    void loginUser()
    {
        //given
		LoginForm user1 = new LoginForm();
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1dj1jd90");
        Optional<LoginForm> userOpt = Optional.of(user1);
        given(userRepo.findById(user1.getEmail())).willReturn(userOpt);

        assertThat(userService.loginUser(user1.getEmail(), user1.getPassword())).isTrue();
    }
}