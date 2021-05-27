package com.natwest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeGeneratorApplicationIntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPrimeNumbersIsOk() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/primes?end=5"))
				.andExpect(status().isOk());
	}

	@Test
	public void testPrimeNumbersUpTo5() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/primes/5"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Primes[0]", is(2)))
				.andExpect(jsonPath("$.Primes[1]", is(3)))
				.andExpect(jsonPath("$.Primes[2]", is(5)));
	}

	@Test
	public void testPrimeNumbersUpTo14() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/primes/14"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Primes[0]", is(2)))
				.andExpect(jsonPath("$.Primes[1]", is(3)))
				.andExpect(jsonPath("$.Primes[2]", is(5)))
				.andExpect(jsonPath("$.Primes[3]", is(7)))
				.andExpect(jsonPath("$.Primes[4]", is(11)))
				.andExpect(jsonPath("$.Primes[5]", is(13)));
	}

	@Test
	public void testPrimeNumbersWithInvalidUpperLimit() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/primes/1"))
				.andExpect(status().isBadRequest());
	}

}
