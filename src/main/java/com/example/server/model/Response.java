package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;

    private Response(Builder builder) {
        this.timeStamp = builder.timeStamp;
        this.statusCode = builder.statusCode;
        this.status = builder.status;
        this.reason = builder.reason;
        this.message = builder.message;
        this.developerMessage = builder.developerMessage;
        this.data = builder.data;
    }

    public static class Builder {
        private LocalDateTime timeStamp;
        private int statusCode;
        private HttpStatus status;
        private String reason;
        private String message;
        private String developerMessage;
        private Map<?, ?> data;

        public Builder timeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder data(Map<?, ?> data) {
            this.data = data;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
