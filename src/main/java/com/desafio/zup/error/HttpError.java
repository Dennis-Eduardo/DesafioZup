package com.desafio.zup.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HttpError {
    private Date timestamp;
    private HttpStatus httpStatus;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> errors;

    @Override
    public String toString() {
        return "HttpError{" +
                "timestamp=" + timestamp +
                ", httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpError httpError = (HttpError) o;
        return Objects.equals(timestamp, httpError.timestamp) && httpStatus == httpError.httpStatus && Objects.equals(message, httpError.message);
    }

    public HttpError(HttpStatus httpStatus, String message, Map<String, String> errors) {
        this.timestamp =  new Date();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    public HttpError(HttpStatus httpStatus, String message) {
        this.timestamp =  new Date();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = new HashMap<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, httpStatus, message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
