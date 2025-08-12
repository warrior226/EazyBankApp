package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The ResponseDto is a data transfer object which is used to send a response
 * of the application to the caller.
 *
 * The object contains two fields: statusCode and statusMessage.
 *
 * The statusCode is a one-word status of the response. It can be "SUCCESS" or
 * "FAILURE".
 *
 * The statusMessage is a detailed message about the status. It can be an error
 * message or a success message.
 */
@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto
{
    @Schema(
            description = "Status code of the response",
            example = "200 SUCCESS"
    )
    private String statusCode;

    @Schema(
            description = "Status message of the response",
            example = "Account created successfully"
    )
    private String statusMessage;
}
