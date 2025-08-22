package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "Account number can not be an null or empty")
    @Pattern(regexp ="(^$|[0-9]{10})$", message = "Mobile number should be 10 digits")
    @Schema(
            description = "Account number of the customer",
            example = "1234567890"
    )
    private Long accountNumber;

    @Schema(
            description = "Account type",
            example = "SAVINGS"
    )
    @NotEmpty(message = "Customer Id can not be an null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address",
            example = "Ouagadougou,Karpala Secteur 51"
    )
    @NotEmpty(message = "Branch address can not be an null or empty")
    private String  branchAddress;
}
