package com.stepasha.zoo.exceptions;

// todo 2 validation error (no constructors because there is one by default)
public class ValidationError
{
    private String Code; //whats being changed
    private String message; //whats the problem

    public String getCode()
    {
        return Code;
    }

    public void setCode(String code)
    {
        Code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ValidationError{" + "Code='" + Code + '\'' + ", message='" + message + '\'' + '}';
    }
}

