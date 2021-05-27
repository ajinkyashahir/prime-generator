package com.natwest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PrimeResponse {

    Integer initial;
    List<Integer> primes;

    @JsonProperty("Initial")
    public Integer getInitial() {
        return initial;
    }
    @JsonProperty("Initial")
    public void setInitial(Integer initial) {
        this.initial = initial;
    }
    @JsonProperty("Primes")
    public List<Integer> getPrimes() {
        return primes;
    }
    @JsonProperty("Primes")
    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }



}
