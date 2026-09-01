package com.example.SpringBasics.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Integer calculateSum(Integer i , Integer j){
        return i+j;
    }
}
