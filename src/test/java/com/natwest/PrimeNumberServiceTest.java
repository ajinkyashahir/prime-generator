package com.natwest;

import com.natwest.model.PrimeResponse;
import com.natwest.service.PrimeNumberService;
import com.natwest.validator.PrimeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimeNumberServiceTest {

    @Mock
    private PrimeValidator primeValidator;

    @InjectMocks
    private PrimeNumberService primeNumberService;

    @Test
    public void testPrimeNumberServiceWithUpperLimit5() {
        PrimeResponse primeResponse = primeNumberService.getPrimeNumbersInRange(5);
        assertEquals(primeResponse.getPrimes().get(0).longValue(), 2);
        assertEquals(primeResponse.getPrimes().get(1).longValue(), 3);
        assertEquals(primeResponse.getPrimes().get(2).longValue(), 5);
    }

}
