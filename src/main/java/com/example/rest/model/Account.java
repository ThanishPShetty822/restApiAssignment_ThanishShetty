package com.example.rest.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Account Information")
public class Account {

    @Schema(
            description = "Unique Account Identifier",
            example = "1001"
    )
    private Long accountId;

    @NotBlank(message = "Customer name is required")
    @Schema(
            description = "Customer Name",
            example = "Rahul"
    )
    private String customerName;

    @NotBlank(message = "Account type is required")
    @Schema(
            description = "Account Type",
            example = "SAVINGS"
    )
    private String accountType;

    @PositiveOrZero(message = "Balance cannot be negative")
    @Schema(
            description = "Account Balance",
            example = "5000"
    )
    private Double balance;

    @Email(message = "Please provide a valid email")
    @Schema(
            description = "Customer Email",
            example = "Rahul@test.com"
    )
    private String email;

    @NotBlank(message = "Status is required")
    @Schema(
            description = "Account Status",
            example = "ACTIVE"
    )
    private String status;

    public Account() {
    }

    public Account(Long accountId,
                   String customerName,
                   String accountType,
                   Double balance,
                   String email,
                   String status) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}