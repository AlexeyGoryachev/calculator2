package com.goryachevhw.calculator2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Calculator2Controller.class)
public class Calculator2ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Calculator2Service calculator2Service;

    @BeforeEach
    public void setUp() {
        when(calculator2Service.plus(2, 2)).thenReturn(4);
        when(calculator2Service.plus(-2, 2)).thenReturn(0);
        when(calculator2Service.plus(-2, -2)).thenReturn(-4);
        when(calculator2Service.minus(2, 2)).thenReturn(0);
        when(calculator2Service.minus(-2, 2)).thenReturn(-4);
        when(calculator2Service.minus(-2, -2)).thenReturn(0);
        when(calculator2Service.multiply(3, 3)).thenReturn(9);
        when(calculator2Service.multiply(-3, 3)).thenReturn(-9);
        when(calculator2Service.multiply(-3, -3)).thenReturn(9);
        when(calculator2Service.multiply(0, 3)).thenThrow(new IllegalArgumentException("ноль нельзя умножить"));
        when(calculator2Service.multiply(3, 0)).thenThrow(new IllegalArgumentException("на ноль нельзя умножить"));
        when(calculator2Service.divide(3, 3)).thenReturn(1);
        when(calculator2Service.divide(-3, 3)).thenReturn(-1);
        when(calculator2Service.divide(-3, -3)).thenReturn(1);
        when(calculator2Service.divide(0, 3)).thenThrow(new IllegalArgumentException("ноль нельзя разделить"));
        when(calculator2Service.divide(3, 0)).thenThrow(new IllegalArgumentException("на ноль нельзя разделить"));
    }
    @Test
    public void testWelcome() throws Exception {
        mockMvc.perform(get("/calculator2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Добро пожаловать в калькулятор!"));
    }
    @Test
    public void testPlus() throws Exception {
        mockMvc.perform(get("/calculator2/plus?num1=2&num2=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2 + 2 = 4"));
    }
    @Test
    public void testMinus() throws Exception {
        mockMvc.perform(get("/calculator2/minus?num1=2&num2=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2 - 2 = 0"));
    }
    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(get("/calculator2/multiply?num1=3&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("3 * 3 = 9"));
    }
    @Test
    public void testMultiplyZero() throws Exception {
        mockMvc.perform(get("/calculator2/multiply?num1=0&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("ноль нельзя умножить"));
    }
    @Test
    public void testMultiplyByZero() throws Exception {
        mockMvc.perform(get("/calculator2/multiply?num1=3&num2=0"))
                .andExpect(status().isOk())
                .andExpect(content().string("на ноль нельзя умножить"));
    }
    @Test
    public void testDivide() throws  Exception {
        mockMvc.perform(get("/calculator2/divide?num1=3&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("3 / 3 = 1"));
    }
    @Test
    public void testDivideZero() throws  Exception {
        mockMvc.perform(get("/calculator2/divide?num1=0&num2=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("ноль нельзя разделить"));
    }
    @Test
    public void testDivideByZero() throws  Exception {
        mockMvc.perform(get("/calculator2/divide?num1=3&num2=0"))
                .andExpect(status().isOk())
                .andExpect(content().string("на ноль делить нельзя"));
    }
}
