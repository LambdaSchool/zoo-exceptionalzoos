package com.stepasha.zoo.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//todo 1 this is how to set up how the user looks at the error
//todo 1 note this is not a table , never saves
public class ErrorDetail {
    private String title;
    private int status; //code number
    private String detail;
    private String timestamp;
    private String developerMessage;
    // list of errors
    private Map<String, List<ValidationError>> errors = new HashMap<String, List<ValidationError>>();

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getTimestamp()
    {
        return timestamp;
    }
    //todo 3 bring in the time stamp in long format and convert to string
    public void setTimestamp(Long timestamp)
    {
        this.timestamp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(new Date(timestamp));
    }

    public String getDeveloperMessage()
    {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage)
    {
        this.developerMessage = developerMessage;
    }

    public Map<String, List<ValidationError>> getErrors()
    {
        return errors;
    }

    public void setErrors(Map<String, List<ValidationError>> errors)
    {
        this.errors = errors;
    }

    @Override
    public String toString()
    {
        return "ErrorDetail{" + "title='" + title + '\'' + ", status=" + status + ", detail='" + detail + '\'' + ", timestamp='" + timestamp + '\'' + ", developerMessage='" + developerMessage + '\'' + ", errors=" + errors + '}';
    }
}
