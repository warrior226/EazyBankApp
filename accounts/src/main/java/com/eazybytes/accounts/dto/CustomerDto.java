package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * This class represents a customer and is used as a Data Transfer Object (DTO)
 * to transfer data between layers of the application.
 * It is annotated with Lombok's @Data annotation to automatically generate
 * getter and setter methods for all the fields.
 *
 * The fields of this class are:
 * <ul>
 * <li>name: the name of the customer.</li>
 * <li>email: the email of the customer.</li>
 * <li>mobileNumber: the mobile number of the customer.</li>
 * </ul>
 *
 */
@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be an null or empty")
    @Size(min = 5,max = 30, message = "Name should be between 5 and 30 characters")
    private String name;

    @NotEmpty(message = "Email can not be an null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp ="(^$|[0-9]{10})$", message = "Mobile number should be 10 digits")
    private  String mobileNumber;

    private AccountsDto accountsDto;
}
