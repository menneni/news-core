package com.example.upday.newscore.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tej on 22/2/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

    @JsonIgnore
    private HttpStatus httpStatus;
    private String code;
    private Integer status;
    private String message;
    private Long timestamp= Instant.now().toEpochMilli();
    private List<FieldError> errors= new ArrayList<>();

    public  ErrorDetails() {

    }
    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message);
        errors.add(error);
    }

    public ErrorDetails(HttpStatus httpStatus, String message, List<FieldError> errors) {
        super();
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = message;
        this.code=httpStatus.name();
        this.errors = errors;

    }

    public ErrorDetails(HttpStatus httpStatus,String message) {
        super();
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = message;
        this.code=httpStatus.name();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.code=httpStatus.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorDetails [httpStatus=" + httpStatus + ", code=" + code + ", status=" + status + ", message="
                + message + ", timestamp=" + timestamp + ", errors=" + errors + "]";
    }
}

