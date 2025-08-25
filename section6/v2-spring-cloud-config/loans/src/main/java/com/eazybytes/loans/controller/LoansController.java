package com.eazybytes.loans.controller;


import com.eazybytes.loans.LoansConstant.LoansConstant;
import com.eazybytes.loans.dto.ErrorResponseDto;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.dto.LoansInfoDto;
import com.eazybytes.loans.dto.ResponseDto;
import com.eazybytes.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author Wendyam RAYAISSE
 */
@Tag(
        name = "CRUD REST APIs for Loans in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE loan details"
)
@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoansController {
    private final ILoansService iLoansService;
    public LoansController(ILoansService iLoansService) {
        this.iLoansService = iLoansService;
    }

    @Autowired
    private LoansInfoDto loansContactInfoDto;

    @Value("${build.version}")
    private String buildVersion;

    @Operation(
            summary = "Create a new loan",
            description = "REST API to create new loan inside EazyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "HTTP Status CREATED"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )
                    )
            }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                      @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                      String mobileNumber){
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstant.STATUS_201,LoansConstant.MESSAGE_201));
    }

    @Operation(
            summary="update loan details",
            description="REST API to update loan details based on an account number inside EazyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Expectation Failed"
                    )
            }
    )
    @PostMapping("/update")
    public  ResponseEntity<ResponseDto> updateLoan(@RequestBody @Valid LoansDto loansDto){
        boolean isUpdated=iLoansService.updateLoan(loansDto);

        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstant.STATUS_200,LoansConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstant.STATUS_417,LoansConstant.MESSAGE_417_UPDATE));
        }

    }

    @Operation(
            summary = "Delete Loan Details REST API",
            description = "REST API to delete Loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                         String mobileNumber) {
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_DELETE));
        }
    }

    @Operation(
            summary = "Fetch Loan Details REST API",
            description = "REST API to fetch loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }



    @Operation(
            summary = "Get Contact Info",
            description = "Contact Info details that can be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<LoansInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansContactInfoDto);
    }


    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into cards microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }


}
