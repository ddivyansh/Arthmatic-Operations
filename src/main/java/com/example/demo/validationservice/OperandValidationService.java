package com.example.demo.validationservice;

import com.example.demo.exceptions.OperandDataException;
import com.example.demo.exceptions.OperationException;
import com.example.demo.operand.Operand;
import org.springframework.stereotype.Service;
/*
A service that performs data validation for instances of Operand class.
 */
@Service
public class OperandValidationService {
    public void objectValidation(Operand operand) throws Exception {
        boolean flag = false;
        try {
            double one = Double.parseDouble(operand.getFirstNumber());
            double two = Double.parseDouble(operand.getSecondNumber());
        } catch (NumberFormatException e) {
            throw new OperandDataException();
        }
        try {
            String operation = operand.getOperation().toLowerCase();
            if (operation.equals("addition") || operation.equals("subtraction") || operation.equals("division") || operation.equals("multiplication"))
                flag = true;
            if (!flag)
                throw new OperationException();
        } catch (OperationException e) {
            throw new OperationException();
        }
    }
}
