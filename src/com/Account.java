package com;

import java.security.SecureRandom;
import java.time.LocalDate;

public class Account {
    private LocalDate accountOpeningDate;
    private int accountId;
    private String nubanNumber;
    private final double minimumBalance;
    private double accountBalance;



    public Account(LocalDate accountOpeningDate, double accountBalance) {
        this.accountOpeningDate = accountOpeningDate;
        this.accountId = idGenerator();
        nubanCode();
        this.accountBalance = accountBalance;
        this.minimumBalance = 5000.0;
    }

    SecureRandom random = new SecureRandom();
    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public int idGenerator() {
        return 1000 + random.nextInt(9998);
    }

    public int getAccountId() {
        return accountId;
    }

    public int nubanGenerator() {
        return 100000 + random.nextInt(999998);
    }

    public void nubanCode() {
       final String NUBAN_CODE = "0100";
       this.nubanNumber = NUBAN_CODE + nubanGenerator();
    }

    public String getNubanNumber() {
        return nubanNumber;
    }

    public double hasMinimumBalance() {
        return minimumBalance;
    }

    public void canDepositCash(double newDeposits) {
        this.accountBalance = (accountBalance + newDeposits) - minimumBalance;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void canWithdrawCash(double newWithdrawals) {
        boolean withdrawalAmountIsValid = newWithdrawals > 0.0;
        boolean depositCashIsInsufficient = getBalance() > newWithdrawals;
        if(withdrawalAmountIsValid && depositCashIsInsufficient){
            this.accountBalance = (accountBalance - newWithdrawals);
        }
        else {
            System.out.println("Transaction cannot be Completed");
        }

    }
}
