package com.test.Exceptions;

public class NotImplementedException extends RuntimeException {
        public NotImplementedException() {
            super("Current request in Not Implemented");
        }
}
