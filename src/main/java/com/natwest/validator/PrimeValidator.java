package com.natwest.validator;

import com.natwest.exception.InvalidInputException;
import org.springframework.stereotype.Component;

@Component
public class PrimeValidator implements Validator<Integer>{

    @Override
    public void validate(Integer request) {
        if(request < 2) {
            throw new InvalidInputException("Upper limit is not valid");
        }
    }
}
