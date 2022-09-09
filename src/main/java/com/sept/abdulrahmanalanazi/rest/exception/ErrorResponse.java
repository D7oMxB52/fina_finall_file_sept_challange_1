package com.sept.abdulrahmanalanazi.rest.exception;

import java.util.List;


// copyright from homy
// link: https://github.com/Homy1/Springbootdemo/blob/master/src/main/java/com/homy/rest/exception/

public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}