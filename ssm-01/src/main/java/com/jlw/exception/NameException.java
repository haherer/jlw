package com.jlw.exception;

//姓名有问题时抛出异常
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
