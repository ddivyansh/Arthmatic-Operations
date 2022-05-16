package com.example.demo.exceptions;
/*
A custom exception to deal with invalid operation.
 */
public class OperationException extends Exception{
    @Override
    public String toString() {
        return "Exception : Please add valid operation";
    }
}
