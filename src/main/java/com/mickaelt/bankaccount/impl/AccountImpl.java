package com.mickaelt.bankaccount.impl;

import com.mickaelt.bankaccount.Account;
import com.mickaelt.bankaccount.business.Operation;
import com.mickaelt.bankaccount.business.OperationType;
import com.mickaelt.bankaccount.exceptions.IllegalBalanceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountImpl implements Account {

    private double balance;

    private List<Operation> operations;

    public AccountImpl() {
        this.operations = new ArrayList<Operation>();
    }

    public void makeDeposit(double deposit) {
        this.balance += deposit;
        this.operations.add(new Operation(OperationType.DEPOSIT, new Date(), deposit, this.balance));
    }

    public void makeWithdrawal(double withdrawal) throws IllegalBalanceException {
        double remainingBalance = this.balance - withdrawal;

        if (!this.isWithdrawPermitted(remainingBalance)) {
            throw new IllegalBalanceException(remainingBalance);
        }

        this.balance = remainingBalance;
        this.operations.add(new Operation(OperationType.WITHDRAWAL, new Date(), withdrawal, this.balance));
    }

    private boolean isWithdrawPermitted(double remainingBalance) {
        return remainingBalance >= 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<Operation> getOperations() {
        return this.operations;
    }

}
