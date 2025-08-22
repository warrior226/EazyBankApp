package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
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
 * @RestController: This annotation is used to mark a class as a web request handler.
 * It is a convenience annotation that combines the @Controller and @ResponseBody annotations.
 * It is a specialized version of the @Component annotation and is used to mark a class as a Spring MVC controller where every method returns a domain object instead of a view.
 * It is used to annotate the class which will be used to handle web requests.
 *
 * @RequestMapping: This annotation is used to map web requests onto methods in request-handler classes with @Controller.
 * It is used to map the HTTP request to the handler method.
 * In this case, it is used to map the "/api" path to the AccountsController class.
 * The "produces" attribute is used to specify the media type of the response.
 * The "path" attribute is used to specify the path of the request.
 *
 * @AllArgsConstructor: This annotation is used to generate a constructor with all the fields of the class as parameters.
 * It is used to inject the dependencies of the class through the constructor.
 * In this case, it is used to inject the IAccountsService dependency to the AccountsController class.
 */
@Tag(
        name = "CRDU REST APIs for Accounts in EazyBank",
        description="CRUD REST APIs in EazyBank to CREATE, READ, UPDATE, and DELETE accounts"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class    AccountsController {

    private final IAccountsService iAccountsService;

    public AccountsController(IAccountsService iAccountsService) {
        this.iAccountsService = iAccountsService;
    }
    @Value("${build.version}")
    private String buildVersion;

    /**
     * This API is used to create a new account.
     * It is a POST request. The request body should be a JSON object with the following fields:
     * <ul>
     *     <li>name: the name of the customer.</li>
     *     <li>email: the email of the customer.</li>
     *     <li>mobileNumber: the mobile number of the customer.</li>
     * </ul>
     * The API returns a JSON object with the following fields:
     * <ul>
     *     <li>status: the status of the response. For a successful request, the status is 201.</li>
     *     <li>message: the message of the response. For a successful request, the message is "Account created successfully".</li>
     * </ul>
     * The API is located at path "/api/create".
     */
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @Operation(
            summary = "Create Account REST API",

            description = "REST API to create new Customer & Account inside EazyBank"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account Details REST API",

            description = "REST API to fetch Customer & Account details based on an account number inside EazyBank"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping("/fetch")
    public  ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                                @Pattern(regexp ="(^$|[0-9]{10})$", message = "Mobile number should be 10 digits")
                                                                String mobileNumber){
       CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);

       return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }


    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema =@Schema(implementation = ErrorResponseDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Expectation Failed"
                    )
            }
    )
    @Operation(
            summary = "Update Account Details REST API",

            description = "REST API to update Customer & Account details based on an account number inside EazyBank"
    )
     @PutMapping("/update")
    public
     ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){

        boolean isUpdatted=iAccountsService.updateAccount(customerDto);
        if(isUpdatted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
     }


    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Expectation Failed"
                    )
            }
    )
    @Operation(
            summary = "Delete Account and Customer Details REST API",

            description = "REST API to delete Customer & Account details based on an account number inside EazyBank"
    )
     @DeleteMapping("/delete")
     public ResponseEntity<ResponseDto> deleteAccount(
             @RequestParam
             @Pattern(regexp ="(^$|[0-9]{10})$", message = "Mobile number should be 10 digits")
             String mobileNumber){
        boolean isDeleted= iAccountsService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
     }

     @GetMapping("/build-info")
     @Operation(
             summary = "Get Build Version of the application REST API",
             description = "REST API to get the build version of the application"
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
     public ResponseEntity<String> getBuildVersion(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
     }

}
