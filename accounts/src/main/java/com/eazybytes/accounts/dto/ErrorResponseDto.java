package com.eazybytes.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class represents an error response which is used to communicate
 * errors to the consumer of the REST API.
 * The error response contains the error code, error message, API path
 * which is the path of the API that caused the error, and the time at which
 * the error occurred.
 * The error code, error message, and API path are all required fields.
 * The error time is automatically populated with the current time.
 * The error response is used to send the error to the consumer of the
 * REST API so that they can handle the error in their application.
 */
@Data @AllArgsConstructor
public class ErrorResponseDto {

    private String errorCode;
    private String errorMessage;
    private  String apiPath;
    private LocalDateTime errorTime;
}
