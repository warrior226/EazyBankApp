package com.eazybytes.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "Account number can not be an null or empty")
    @Pattern(regexp ="(^$|[0-9]{10})$", message = "Mobile number should be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Customer Id can not be an null or empty")
    private String accountType;

    @NotEmpty(message = "Branch address can not be an null or empty")
    private String  branchAddress;
}
