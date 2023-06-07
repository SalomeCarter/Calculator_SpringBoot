package com.example.calculator_springboot.storage;

import com.example.calculator_springboot.service.CalculatorOperation;

import java.util.List;

public interface OperationStorage {
    public void save(CalculatorOperation operation);

    public List<CalculatorOperation> findAll();
    List<CalculatorOperation> findAllByUsername(String username);
}
