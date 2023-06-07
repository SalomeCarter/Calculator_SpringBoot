package com.example.calculator_springboot.service;

import com.example.calculator_springboot.entity.User;

public interface CalculatorOperation {
    void process();
    double getFinalResult();
    User getAuthor();
}
