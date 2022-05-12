package com.example.demo.operationController;

import com.example.demo.buisnessLogic.BusinessLogic;
import com.example.demo.operand.Operand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OperationController {
    /*
    This class contains the URL mapping and the requests for different operations
    */
    @Autowired
    private BusinessLogic logicOne;

    @RequestMapping("/home")
    public String sayHI()
    {
        return "Go through readme to get started with application";
    }

    //Operation through URL
    @RequestMapping(method = RequestMethod.GET,value = "/{a}/{operation}/{b}")
    public String perform(@PathVariable String a, @PathVariable String operation, @PathVariable String b)
    {
        //validation for the input
        try {
            double one = Double.parseDouble(a);
            double two = Double.parseDouble(b);
        }
        catch (Exception e)
        {
            return "Please enter the correct input as the application has encountered an exception : "+e.toString();
        }

        logicOne.setA(Double.parseDouble(a));
        logicOne.setB(Double.parseDouble(b));
        return logicOne.performCalculation(operation);
    }

    //Operation through JSON parsing to a Java object
    @RequestMapping(method = RequestMethod.GET, value = "/calculate")
    public String peformTwo(@RequestBody Operand op)
    {
        //validation for the input
        try {
            double one = Double.parseDouble(op.getFirstNumber());
            double two = Double.parseDouble(op.getSecondNumber());
            String operation = op.getOperation();
        }
        catch (Exception e)
        {
            return "Please enter the correct input as the application has encountered an exception : "+e.toString();
        }

        logicOne.setA(Double.parseDouble(op.getFirstNumber()));
        logicOne.setB(Double.parseDouble(op.getSecondNumber()));
        return logicOne.performCalculation(op.getOperation());
    }


}
