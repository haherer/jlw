package com.jlw.exception;

//年龄有问题时抛出异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
