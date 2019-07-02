package com.test.Exceptions;

public class InvalidInputException extends RuntimeException{
        public InvalidInputException() {
            super("Invalid input parameter found");
        }
}
