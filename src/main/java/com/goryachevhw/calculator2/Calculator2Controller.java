package com.goryachevhw.calculator2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator2")
public class Calculator2Controller {
    private final Calculator2Service calculator2Service;

    @Autowired
    public Calculator2Controller(Calculator2Service calculator2Service) {
        this.calculator2Service = calculator2Service;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор!";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculator2Service.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculator2Service.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            int result = calculator2Service.multiply(num1, num2);
            return num1 + " * " + num2 + " = " + result;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            int result = calculator2Service.divide(num1, num2);
            return num1 + " / " + num2 + " = " + result;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
