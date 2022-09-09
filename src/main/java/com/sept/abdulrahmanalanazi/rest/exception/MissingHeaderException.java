package com.sept.abdulrahmanalanazi.rest.exception;



// copyright from homy
// link: https://github.com/Homy1/Springbootdemo/blob/master/src/main/java/com/homy/rest/exception/


public class MissingHeaderException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public MissingHeaderException(String exception) {
        super(exception);
    }
}
