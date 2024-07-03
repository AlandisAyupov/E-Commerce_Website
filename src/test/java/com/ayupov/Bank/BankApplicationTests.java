package com.ayupov.Bank;

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


}