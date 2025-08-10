package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;

public interface IAccountsService {

    /**
     * Creates a new account with the given customer information.
     *
     * @param customerDto
     *            The customer information. It should have name, email, and
     *            mobileNumber.
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String accountNumber);
    boolean updateAccount(CustomerDto customerDto);
}
