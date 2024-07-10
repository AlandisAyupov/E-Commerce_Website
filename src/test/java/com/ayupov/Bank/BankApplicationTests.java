package com.ayupov.Bank;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	@Test
	void contextLoads() {
		Allure.step("contextLoads");
	}

	@Test
	public void assertIfTrue() {
		Allure.step("assertEven");
		assertTrue(true);
	}

	 @Test
    void getAllUsers()
    {
        //given
		User user1 = new User();
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1dj1jd90");
		userService.addUser(user1);
        //When
        given(userRepo.findAll())
        .willReturn(List.of(user1));
        var list = userService.getUsers();
    	//Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(list).isNotNull().hasSize(1);
    } 
	
	@Test
    void getAllUsers()
    {
        //given
		User user1 = new User();
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1dj1jd90");
		userService.addUser(user1);
        //When
        given(userRepo.findAll())
        .willReturn(List.of(user1));
        var list = userService.getUsers();
    	//Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(list).isNotNull().hasSize(1);
    }
}