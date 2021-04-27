package com.natwest.validator;

@FunctionalInterface
public interface Validator<T> {

    void validate(T request);
}
