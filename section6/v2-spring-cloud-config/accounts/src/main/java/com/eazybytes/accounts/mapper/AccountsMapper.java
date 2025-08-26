package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;

/**
 * The AccountsMapper is a utility class that is used to convert the Accounts entity
 * to the AccountsDto and vice versa. This class is used by the AccountsService to
 * convert the Accounts entity to the AccountsDto which is then returned to the consumer
 * of the REST API. This class is also used to convert the AccountsDto which is passed
 * to the AccountsService to the Accounts entity which is then persisted in the database.
 * The AccountsMapper is a utility class and it does not have any state of its own.
 * It only provides static methods to convert the Accounts entity to the AccountsDto
 * and vice versa. The AccountsMapper is used to encapsulate the logic of converting
 * the Accounts entity to the AccountsDto and vice versa. The AccountsMapper is used
 * to separate the concern of converting the Accounts entity to the AccountsDto and
 * vice versa from the AccountsService. The AccountsMapper is used to reduce the
 * complexity of the AccountsService and make it more maintainable.
 */
public class AccountsMapper {

    public  static AccountsDto mapToAccountsDto(Accounts accounts,AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
