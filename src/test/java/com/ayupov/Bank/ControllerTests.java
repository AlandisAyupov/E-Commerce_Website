package com.ayupov.Bank;

//USing BDD Mockito 
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import com.ayupov.Bank.user.User;
import com.ayupov.Bank.user.UserRepository;
import com.ayupov.Bank.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
 
@ExtendWith(MockitoExtension.class)
 
// Main class
class ControllerTests {
 
    @Mock
    private UserRepository userRepo;
    //When using Mockito Use @InjectMocks to inject
    //Mocked beans to following class
    @InjectMocks
    private UserService userService;
 
    @Test 
    void addUser()
    {
        //given
		User user1 = new User();
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
		User user1 = new User();
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1dj1jd90");
        Optional<User> userOpt = Optional.of(user1);
        given(userRepo.findById(user1.getEmail())).willReturn(userOpt);

        assertThat(userService.loginUser(user1.getEmail(), user1.getPassword())).isTrue();
    }

    // @Test
    // void getAllUsers()
    // {
    //     // //given
	// 	// User user1 = new User();
	// 	// user1.setEmail("abc@gmail.com");
	// 	// user1.setPassword("1dj1jd90");
	// 	// userService.addUser(user1);
    //     // //When
    //     // given(userRepo.findAll())
    //     // .willReturn(List.of(user1));
    // 	// //Then
    //     // //Make sure to import assertThat From org.assertj.core.api package
    //     // assertThat(userService.getUsers()).isNotNull().hasSize(1);
    // }
}