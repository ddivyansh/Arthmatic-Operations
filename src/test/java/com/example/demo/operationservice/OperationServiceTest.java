package com.example.demo.operationservice;

import com.example.demo.operand.Operand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class OperationServiceTest {
    Operand operand;
    OperationService operationServiceOne;

    @BeforeEach
    public void beforeAll() {
        operand = new Operand();
        operationServiceOne = new OperationService();
        operand.setFirstNumber("24");
        operand.setSecondNumber("56");
    }

    @ParameterizedTest
    @DisplayName("Parameterized test for different operations with same input")
    @ValueSource(strings = {"addition", "subtraction", "multiplication", "division", "Addition"})
    public void calculateCheck(String operation) {
        operand.setOperation(operation);
        switch (operation.toLowerCase()) {
            case "addition" -> Assertions.assertEquals(80.0, operationServiceOne.performCalculation(operand));
            case "subtraction" -> Assertions.assertEquals(-32.0, operationServiceOne.performCalculation(operand));
            case "multiplication" -> Assertions.assertEquals(1344.0, operationServiceOne.performCalculation(operand));
            case "division" -> Assertions.assertEquals(0.43, operationServiceOne.performCalculation(operand));
        }


    }


}


