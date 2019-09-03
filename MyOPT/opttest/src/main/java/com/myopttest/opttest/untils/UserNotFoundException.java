package com.myopttest.opttest.untils;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String information){
        super(information);
    }
}
