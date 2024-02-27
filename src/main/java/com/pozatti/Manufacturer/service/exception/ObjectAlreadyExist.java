package com.pozatti.Manufacturer.service.exception;

public class ObjectAlreadyExist extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectAlreadyExist(String msg){
        super(msg);
    }

}
