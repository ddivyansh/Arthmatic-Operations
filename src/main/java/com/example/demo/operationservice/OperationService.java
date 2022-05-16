package com.example.demo.operationservice;

import com.example.demo.operand.Operand;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    private double calculate(String operation, String nOne, String nTwo) {
        double numberOne = Double.parseDouble(nOne);
        double numberTwo = Double.parseDouble(nTwo);
        double result = 0;
        switch (operation.toLowerCase()) {
            case "addition" -> result = numberOne + numberTwo;
            case "subtraction" -> result = numberOne - numberTwo;
            case "division" -> result = numberOne / numberTwo;
            case "multiplication" -> result = numberOne * numberTwo;
        }
        return result;
    }

    public double performCalculation(Operand operand) {
        return Math.round((calculate(operand.getOperation(), operand.getFirstNumber(), operand.getSecondNumber())*100.0))/100.0;

    }


}
