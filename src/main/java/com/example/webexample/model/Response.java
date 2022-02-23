package com.example.webexample.model;

public class Response {

    private Long code;
    private String message;
    private Long timestamp;

    public Response() {
        super();
    }

    public Response(Long code, String message, Long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
