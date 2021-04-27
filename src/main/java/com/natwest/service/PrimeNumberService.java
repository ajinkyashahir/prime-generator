package com.natwest.service;

import com.natwest.validator.PrimeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeNumberService {

    @Autowired
    private PrimeValidator primeValidator;

    Logger logger = LoggerFactory.getLogger(PrimeNumberService.class);

    public List<Integer> getPrimeNumbersInRange(Integer end) {
        primeValidator.validate(end);
        return IntStream.rangeClosed(2, end)
                .filter(number -> isPrime(number)).boxed()
                .collect(Collectors.toList());
    }

    private boolean isPrime(int number) {
        boolean isPrime = IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
        logger.debug("Number:{} isPrime:{}", number, isPrime);
        return isPrime;
    }

}
