package com.goryachevhw.calculator2;

import org.springframework.stereotype.Service;

@Service
public class Calculator2Service {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }
    public int minus(int num1, int num2) {
        return num1 - num2;
    }
    public int multiply(int num1, int num2) {
        if (num1 == 0) {
            throw new IllegalArgumentException("ноль нельзя умножить");
        } else if (num2 == 0) {
            throw new IllegalArgumentException("на ноль нельзя умножить");
        } else {
            return num1 * num2;
        }
    }
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("на ноль делить нельзя");
        } else if (num1 == 0) {
            throw new IllegalArgumentException("ноль нельзя разделить");
        } else {
            return num1 / num2;
        }
    }
}
