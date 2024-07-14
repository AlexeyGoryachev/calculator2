package com.goryachevhw.calculator2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/calculator2")
public class Calculator2Controller {
    private final Calculator2Service calculator2Service;
    private final Calculator2Validator calculator2Validator;

    @Autowired
    public Calculator2Controller(Calculator2Service calculator2Service, Calculator2Validator calculator2Validator) {
        this.calculator2Service = calculator2Service;
        this.calculator2Validator = calculator2Validator;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор!";
    }
    @GetMapping("/plus")
    public String plus(@ModelAttribute @Valid Calculator2Request request, BindingResult bindingResult) {
        calculator2Validator.validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        int result = calculator2Service.plus(request.getNum1(), request.getNum2());
        return request.getNum1() + " + " + request.getNum2() + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@ModelAttribute @Valid Calculator2Request request, BindingResult bindingResult) {
        calculator2Validator.validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        int result = calculator2Service.minus(request.getNum1(), request.getNum2());
        return request.getNum1() + " - " + request.getNum2() + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@ModelAttribute @Valid Calculator2Request request, BindingResult bindingResult) {
        calculator2Validator.validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        try {
            int result = calculator2Service.multiply(request.getNum1(), request.getNum2());
            return request.getNum1() + " * " + request.getNum2() + " = " + result;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/divide")
    public String divide(@ModelAttribute @Valid Calculator2Request request, BindingResult bindingResult) {
        calculator2Validator.validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        try {
            int result = calculator2Service.divide(request.getNum1(), request.getNum2());
            return request.getNum1() + " / " + request.getNum2() + " = " + result;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
