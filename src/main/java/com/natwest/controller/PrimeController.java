package com.natwest.controller;

import com.natwest.service.PrimeNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PrimeController {

    Logger logger = LoggerFactory.getLogger(PrimeController.class);

    @Autowired
    PrimeNumberService primeNumGenService;

    @GetMapping(path = "api/primes")
    public List<Integer> getPrimeNumbers(@RequestParam Integer end) {
        logger.info("Prime numbers API invoked with upper limit {} ", end);
        return primeNumGenService.getPrimeNumbersInRange(end);
    }

}
