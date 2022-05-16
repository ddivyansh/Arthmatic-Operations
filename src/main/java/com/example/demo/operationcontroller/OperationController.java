package com.example.demo.operationcontroller;

import com.example.demo.operand.Response;
import com.example.demo.operationservice.OperationService;
import com.example.demo.operand.Operand;
import com.example.demo.validationservice.OperandValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
    This class contains POST method to parse incoming JSON
    Things to be done :
        add unit testing
*/
@RestController
public class OperationController {

    @Autowired
    private OperationService operationServiceOne;
    @Autowired
    private OperandValidationService operandValidationServiceOne;

    @RequestMapping("/home")
    public String sayHI() {
        return "Go through readme to get started with application";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    public ResponseEntity<Response> perform(@Valid @RequestBody Operand operand) {
        try {
            operandValidationServiceOne.objectValidation(operand);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.toString()),HttpStatus.BAD_REQUEST);
        }
//        Response response = new Response(logicOne.performCalculation(operand));
        return new ResponseEntity<>(new Response(Double.toString(operationServiceOne.performCalculation(operand))), HttpStatus.OK);
    }


}
