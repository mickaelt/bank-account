package com.mickaelt.bankaccount.exceptions;

public class IllegalBalanceException extends Exception {

    private double balance;

    public IllegalBalanceException(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "IllegalBalanceException { balance = " + balance  + " }";
    }

}
