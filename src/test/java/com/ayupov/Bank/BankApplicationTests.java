package com.ayupov.Bank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	@Test
	void contextLoads() {
		Allure.step(String.format("contextLoads"));
	}

	@Test
	public void givenNumber_whenEven_thenTrue() {
		Allure.step("assertEven");
		assertTrue(2 % 2 == 0);
	}


}