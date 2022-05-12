package com.example.demo.buisnessLogic;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BusinessLogic {
    //This service contains the logic of the application
    private double a;
    private double b;
    private double result;

    private double calculate(String operation)
    {
        switch (operation.toLowerCase()) {
            case "addition" -> result = a + b;
            case "subtraction" -> result = a - b;
            case "division" -> result = a / b;
            case "multiplication" -> result = a * b;
            default -> result=Double.MIN_VALUE;// in case of invalid input
        }
        return result;
    }
    public String performCalculation(String operation)
    {
        double res = calculate(operation);
        if(res==Double.MIN_VALUE)
            return "Please enter valid operation";
        else return "The result is : "+Double.toString(res);
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }
}
