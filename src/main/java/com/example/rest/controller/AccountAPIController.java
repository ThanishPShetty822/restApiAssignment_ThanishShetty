package com.example.rest.controller;

import com.example.rest.model.Account;
import com.example.rest.response.ResponseHandler;
import com.example.rest.service.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account API",
        description = "Operations related to Account")
public class AccountAPIController {

    AccountServiceImpl service;
    Account account;

    public AccountAPIController(AccountServiceImpl service) {

        this.service=service;
    }


    @Operation(
            summary = "Get account By ID",
            description = "Returns Customer details for the given account id"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Customer found"),
            @ApiResponse(responseCode = "404",
                    description = "Customer not found")
    })
    @GetMapping("/{accountId}")
    public ResponseEntity<Object> getAccountDetails(@PathVariable String accountId) {


       return ResponseHandler.responseBuilder(
                "Requested account details are given here",
                HttpStatus.OK,
                service.getAccount(accountId));

    }



    @Operation(
            summary = "Get All Accounts",
            description = "Returns a list of all Accounts"
    )
    @GetMapping("")
    public List<Account> getAccountDetails() {

        System.out.println("Hii");
        return service.getAllAccounts();
    }



    @Operation(
            summary = "create Account",
            description = "Creates a new Account"
    )
    @PostMapping("/create")
    public String createAccountDetails(@Valid @RequestBody Account account){
        return service.createAccount(account);
    }

    @Operation(
            summary = "update Account",
            description = "updates the existing Account using accountId"
    )
    @PutMapping("")
    public String updateAccountDetails(@Valid @RequestBody Account account){
        service.updateAccount(account);
        return "Updation Successfull";
    }


    @Operation(
            summary = "Delete Customer",
            description = "delete Account using the accountId"
    )
    @DeleteMapping("/{accountId}")
    public String deleteAccountDetails(@PathVariable String accountId){
        return service.deleteAccount(accountId);

    }

    @Operation(
            summary = "Partially Update Account",
            description = "Updates only the provided fields of an account"
    )
    @PatchMapping("/{accountId}")
    public String patchAccount(
            @PathVariable Long accountId,
            @RequestBody Map<String,Object> updates) {

       return service.patchAccount(accountId, updates);

    }


}
