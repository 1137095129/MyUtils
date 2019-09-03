package com.myopttest.opttest.untils;

public class UserExistsException extends Throwable {
    public UserExistsException(){
        super();
    }

    public UserExistsException(String information){
        super(information);
    }
}
