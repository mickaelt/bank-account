package com.mickaelt.bankaccount;

import com.mickaelt.bankaccount.business.Operation;
import com.mickaelt.bankaccount.exceptions.IllegalBalanceException;

import java.util.List;

/**
 * Simple client account
 */
public interface Account {

    /**
     * Make deposit in this account
     * @param deposit the money to add
     */
    void makeDeposit(double deposit);

    /**
     * Get the current account balance
     * @return the account's balance
     */
    double getBalance();

    /**
     * Make withdrawal in this account
     * @param withdrawal the money to withdraw
     */
    void makeWithdrawal(double withdrawal) throws IllegalBalanceException;

    /**
     * Get operations
     * @return all the account's operations
     */
    List<Operation> getOperations();

}
