package com.ayupov.Bank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenNumber_whenEven_thenTrue() {
		assertTrue(2 % 2 == 0);
	}


}