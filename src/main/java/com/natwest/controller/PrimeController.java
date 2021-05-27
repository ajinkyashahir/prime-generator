package com.natwest.controller;

import com.natwest.model.PrimeResponse;
import com.natwest.service.PrimeNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrimeController {

    Logger logger = LoggerFactory.getLogger(PrimeController.class);

    @Autowired
    PrimeNumberService primeNumGenService;

    @GetMapping(path = "primes/{initial}")
    public PrimeResponse getPrimeNumbers(@PathVariable Integer initial) {
        logger.info("Prime numbers API invoked with upper limit {} ", initial);
        return primeNumGenService.getPrimeNumbersInRange(initial);
    }

}
