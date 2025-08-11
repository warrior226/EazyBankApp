package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class    AccountsController {
    /**
     * @Autowired: This annotation is used to mark a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * It is used to inject the dependencies of a class.
     * The dependencies are injected by Spring's IoC container.
     * It is used to remove the need for the programmer to write code to initialize the dependencies of a class.
     * The dependencies are injected automatically by Spring's IoC container.
     * It is used to decouple the dependencies of a class from the class itself.
     * The dependencies are decoupled from the class and are injected by Spring's IoC container.
     * It is used to make the code more modular and more testable.
     * The dependencies are injected automatically by Spring's IoC container.
     * It is used to make the code more maintainable and more scalable.
/* <<<<<<<<<<  e3f674ba-e4cf-4479-8ce0-e767c9073961  >>>>>>>>>>> */
//With @AllArgsConstructor, we can automatically generate a constructor that takes all the arguments we don't need to use @Autowired
    private IAccountsService iAccountsService;


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
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public  ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
       CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);

       return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

     @PutMapping("/update")
    public
     ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto){

        boolean isUpdatted=iAccountsService.updateAccount(customerDto);
        if(isUpdatted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
     }

     @DeleteMapping("/delete")
     public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
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

}
