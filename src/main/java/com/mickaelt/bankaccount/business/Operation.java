package com.mickaelt.bankaccount.business;

import java.util.Date;

public class Operation {

    private OperationType type;

    private Date date;

    private double amount;

    private double balance;

    public Operation() { }

    public Operation(OperationType type, Date date, double amount, double balance) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
