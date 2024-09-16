package com.stepasha.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//todo 5 create custom exception extend RuntimeException
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    //todo 5.1 create two constructors
    public ResourceNotFoundException(String message)
    {
        super(message);
    }

    public ResourceNotFoundException(String message,
                                     Throwable cause)
    {
        super(message,
                cause);
    }
}
