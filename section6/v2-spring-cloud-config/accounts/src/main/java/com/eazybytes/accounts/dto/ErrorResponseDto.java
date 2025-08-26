package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

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
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client"
    )
    private  String apiPath;

    @Schema(
            description = "Error code representing the error happened"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing the error happened"
    )
    private  String errorMessage;

    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime errorTime;

}
