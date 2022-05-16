package com.example.demo.exceptions;
/*
A custom exception to deal with incorrect operands.
 */
public class OperandDataException extends Exception{

    @Override
    public String toString() {
        return "Exception : Please enter correct input !";
    }
}
