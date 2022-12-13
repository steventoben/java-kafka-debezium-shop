package com.example.catalogservice.exception;

import java.util.Date;

public class ErrorMessage {
    private Integer statusCode;
    private String message;
    private String description;
    private Date timestamp;

    public ErrorMessage(Integer statusCode, String message, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
