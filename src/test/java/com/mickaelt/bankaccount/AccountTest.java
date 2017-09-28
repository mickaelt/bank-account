package com.mickaelt.bankaccount;

import com.mickaelt.bankaccount.business.OperationType;
import com.mickaelt.bankaccount.exceptions.IllegalBalanceException;
import com.mickaelt.bankaccount.impl.AccountImpl;
import static org.junit.Assert.*;

import org.junit.*;

/**
 * Test the client account behaviour
 */
public class AccountTest {

    private Account account;

    @Before
    public void init() {
        this.account = new AccountImpl();
    }

    /**
     * Make deposit into the account and check if the new balance is correct
     */
    @Test
    public void testMakeDeposit() {
        /* GIVEN */
        double addedAmount = 10.0;
        double expectedBalance = addedAmount * 2;

        /* WHEN */
        this.account.makeDeposit(addedAmount);
        this.account.makeDeposit(addedAmount);

        /* THEN */
        assertTrue("New balance is not correct", expectedBalance == this.account.getBalance());
    }

    /**
     * Check if an illegal withdrawal throws an exception
     */
    @Test(expected = IllegalBalanceException.class)
    public void testMakeWithdrawalIllegalBalance() throws IllegalBalanceException {
        /* GIVEN */
        double addedAmount = 10.0;
        double withdrawnAmount = 15.0;

        /* WHEN */
        this.account.makeDeposit(addedAmount);
        this.account.makeWithdrawal(withdrawnAmount);

        /* THEN */
        // We expect that an IllegalBalanceException has been thrown and test cannot pass this last assert
        assert(true);
    }

    /**
     * Make withdrawal to the account and check if the new balance is as correct
     */
    @Test
    public void testBalanceIsCorrectAfterWithdrawal() throws IllegalBalanceException {
        /* GIVEN */
        double addedAmount = 15.0;
        double withdrawnAmount = 10.0;
        double expectedBalance = addedAmount - withdrawnAmount;

        /* WHEN */
        this.account.makeDeposit(addedAmount);
        this.account.makeWithdrawal(withdrawnAmount);

        /* THEN */
        assertTrue("New balance is not correct", expectedBalance == this.account.getBalance());
    }

    /**
     * Make operations and check if history is correct
     */
    @Test
    public void testHistoryIsCorrectAfterOperations() throws IllegalBalanceException {
        /* GIVEN */
        double addedAmount = 15.0;
        double withdrawnAmount = 10.0;
        double expectedBalance = addedAmount - withdrawnAmount;
        int operationsQuantity = 2;

        /* WHEN */
        this.account.makeDeposit(addedAmount);
        this.account.makeWithdrawal(withdrawnAmount);

        /* THEN */
        assertTrue("Operation quantity is not correct", operationsQuantity == this.account.getOperations().size());

        assertEquals("Operation type is not correct", OperationType.DEPOSIT, this.account.getOperations().get(0).getType());
        assertTrue("Amount is not correct", addedAmount == this.account.getOperations().get(0).getAmount());
        assertTrue("Balance is not correct", addedAmount == this.account.getOperations().get(0).getBalance());

        assertEquals("Operation type is not correct", OperationType.WITHDRAWAL, this.account.getOperations().get(1).getType());
        assertTrue("Amount is not correct", withdrawnAmount == this.account.getOperations().get(1).getAmount());
        assertTrue("Balance is not correct", expectedBalance == this.account.getOperations().get(1).getBalance());
    }

}
