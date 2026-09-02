package com.example.SpringBasics.controller;

import com.example.SpringBasics.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cal")
public class CalculatorController {

//    CalculatorService calculatorService ;
//
//    public CalculatorController(CalculatorService calculatorService) {
//        this.calculatorService = calculatorService;
//    }


//    @Autowired
//    CalculatorService calculatorService;

    CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
            this.calculatorService = calculatorService;
    }

    @GetMapping("/sum/{firstInt}/{secondtInt}")
    public ResponseEntity<Integer> sum(
            @PathVariable("firstInt") Integer firstInt ,
            @PathVariable("secondtInt") Integer secondtInt
    ){
        Integer ans = calculatorService.calculateSum(firstInt,secondtInt);

        return ResponseEntity.ok(ans);
    }
}
