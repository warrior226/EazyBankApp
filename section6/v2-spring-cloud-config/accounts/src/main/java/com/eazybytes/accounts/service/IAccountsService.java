package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public interface IAccountsService {

    /**
     * Creates a new account with the given customer information.
     *
     * @param customerDto
     *            The customer information. It should have name, email, and
     *            mobileNumber.
     */
    void createAccount(CustomerDto customerDto);
    /**
     * Fetches the account by the given account number.
     *
     * @param accountNumber
     *            The account number to fetch the account.
     * @return The CustomerDto containing the account information.
     */
    CustomerDto fetchAccount(String accountNumber);
    /**
     * Updates the account with the given customer information.
     *
     * @param customerDto
     *            The customer information. It should have name, email, and
     *            mobileNumber.
     * @return true if the account is updated successfully, else false.
     */
    boolean updateAccount(CustomerDto customerDto);


    boolean deleteAccount(String mobileNumber);
}
