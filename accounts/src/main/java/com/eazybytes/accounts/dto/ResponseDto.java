package com.eazybytes.accounts.dto;

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
public class ResponseDto
{
    private String statusCode;

    private String statusMessage;
}
