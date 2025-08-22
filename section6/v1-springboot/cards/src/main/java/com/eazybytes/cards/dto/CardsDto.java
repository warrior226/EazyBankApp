package com.eazybytes.cards.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
public class CardsDto {

    @Schema(
            description = "Mobile Number of Customer", example = "4354437687"
    )
    @NotEmpty(message = "Mobile number can not be an null or empty")
    @Pattern(regexp = "^[0-9]{15}$", message = "Mobile number must be 15 digits")
    private String mobileNumber;

    @Schema(
            description = "Card Number of the customer", example = "100646930341"
    )
    @NotEmpty(message = "Card number can not be an null or empty")
    @Pattern(regexp = "^[0-9]{20}$", message = "Card number must be 20 digits")
    private String cardNumber;

    @Schema(
            description = "Type of the card", example = "Credit Card"
    )
    @NotEmpty(message = "Card type can not be an null or empty")
    private String cardType;

    @Schema(
            description = "Total amount limit available against a card", example = "100000"
    )
    @NotEmpty(message = "Total limit can not be an null or empty")
    @Positive(message = "Total limit should be greater than zero")
    private int totalLimit;

    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    @NotEmpty(message = "Amount used can not be an null or empty")
    @PositiveOrZero(message = "Amount used should be greater than or equal to zero")
    private int amountUsed;

    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    @NotEmpty(message = "Available amount can not be an null or empty")
    @PositiveOrZero(message = "Available amount should be greater than or equal to zero")
    private int availableAmount;
}
