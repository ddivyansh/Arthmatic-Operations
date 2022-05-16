package com.example.demo.validationservice;

import com.example.demo.exceptions.OperandDataException;
import com.example.demo.exceptions.OperationException;
import com.example.demo.operand.Operand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class OperandValidationServiceTest {

    Operand operand;
    OperandValidationService operandValidationService;

    @BeforeEach
    public void objectInit() {
        operand = new Operand();
        operandValidationService = new OperandValidationService();
    }

    @Test
    @DisplayName("Test case for Custom Operation exception i.e valid inputs & invalid operation")
    public void invalidOperationTestCase() {
        operand.setFirstNumber("67.0");
        operand.setSecondNumber("57.0");
        operand.setOperation("add");

        OperationException thrown = Assertions.assertThrows(OperationException.class, () -> operandValidationService.objectValidation(operand));
        Assertions.assertTrue(thrown.toString().contains("Exception : Please add valid operation"));


    }

    @Test
    @DisplayName("Test case for custom operand exception i.e invalid inputs")
    public void invalidInputTestCase() {
        operand.setFirstNumber("abc");
        operand.setSecondNumber("57.0");
        operand.setOperation("add");

        OperandDataException thrown = Assertions.assertThrows(OperandDataException.class, () -> operandValidationService.objectValidation(operand));
        Assertions.assertTrue(thrown.toString().contains("Exception : Please enter correct input !"));

    }
}