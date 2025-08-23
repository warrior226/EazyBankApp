package com.eazybytes.loans.service;

import com.eazybytes.loans.LoansConstant.LoansConstant;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoansMapper;
import com.eazybytes.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {
    private LoansRepository loansRepository;

    /**
     * This method registers a new loan for a given customer.
     *
     * @param mobileNumber The mobile number of the customer.
     * @throws LoanAlreadyExistsException If the loan already exists for the given customer.
     */
    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> optionalLoans=loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * This method creates a new loan for a given customer.
     *
     * @param mobileNumber The mobile number of the customer.
     * @throws LoanAlreadyExistsException If the loan already exists for the given customer.
     */
    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber=1000000000L+new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstant.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstant.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstant.NEW_LOAN_LIMIT);
        return newLoan;
    }

    /**
     * Fetches the loan details based on the provided mobile number.
     *
     * @param mobileNumber The mobile number of the customer.
     * @return The loan details as a LoansDto object.
     * @throws ResourceNotFoundException If the loan details are not found for the provided mobile number.
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans optionalLoans=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
        );
        return LoansMapper.mapToLoansDto(new LoansDto(),optionalLoans);
    }

    /**
     * Updates the loan details for a given customer.
     *
     * @param loansDto The loan details as a LoansDto object.
     * @return True if the loan details are successfully updated, false otherwise.
     * @throws ResourceNotFoundException If the loan details are not found for the provided mobile number.
     */
    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans optionalLoans=loansRepository.findByMobileNumber(loansDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan","mobileNumber",loansDto.getMobileNumber())
        );
        LoansMapper.mapToLoans(optionalLoans,loansDto);
        loansRepository.save(optionalLoans);
        return true;
    }


    /**
     * Registers a new loan for a given customer.
     *
     * @param mobileNumber The mobile number of the customer.
     * @throws LoanAlreadyExistsException If the loan already exists for the given customer.
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans optionalLoans=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
        );
        loansRepository.deleteById(optionalLoans.getLoanId());
        return true;
    }
}
