package com.example.calculator_springboot.controller;

import com.example.calculator_springboot.dto.OperationDto;
import com.example.calculator_springboot.entity.OperationType;
import com.example.calculator_springboot.entity.User;
import com.example.calculator_springboot.factory.OperationFactory;
import com.example.calculator_springboot.service.CalculatorOperation;
import com.example.calculator_springboot.service.OperationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private OperationFactory operationFactory;


    @GetMapping("/calc")
    public String calc(Model model) {
        model.addAttribute("newOperation", new OperationDto());
        return "calc";
    }

    @PostMapping("/calc")
    public String calc(@ModelAttribute("newOperation") @Valid OperationDto dto,
                       HttpSession session,
                       Model model) {

        OperationType opType = OperationType.valueOf(dto.getType().toUpperCase());
        User user = (User) session.getAttribute("user");
        CalculatorOperation operation = operationFactory.getInstance(dto.getNum1(), dto.getNum2(), opType, user);

        double result = operationService.calculate(operation);

        model.addAttribute("result", result);
        return "calc";
    }


    @GetMapping("/history")
    public String history(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<CalculatorOperation> operationList = operationService.findAllByUsername(user.getUsername());
        model.addAttribute("operationList", operationList);
        return "history";
    }
}

