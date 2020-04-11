package com.greeting.exception;

public class GreetingException extends RuntimeException{

    String exceptionMessage;

    public enum ExceptionTypes {
        NO_SUCH_ID;
    }

    public ExceptionTypes exceptionTypes;

    public GreetingException(String message, ExceptionTypes types) {
        super(message);
        this.exceptionMessage = message;
        this.exceptionTypes = types;
    }
}
