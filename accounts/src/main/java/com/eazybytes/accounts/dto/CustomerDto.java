package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
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

    private String name;

    private String email;

    private  String mobileNumber;

    private AccountsDto accountsDto;
}
