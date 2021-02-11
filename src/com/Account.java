package com;

import java.security.SecureRandom;
import java.time.LocalDate;

public class Account {
    private final LocalDate accountOpeningDate;
    private final int accountId;
    private String nubanNumber;
    private final double minimumBalance;
    private double accountBalance;
    private final double interestRate;
    private double depositAmount;
    private double withdrawalAmount;

    public Account(double withdrawalAmount,double depositAmount,double minimumBalance, LocalDate accountOpeningDate, double accountBalance,double interestRate) {
        this.accountOpeningDate = accountOpeningDate;
        this.accountId = idGenerator();
        nubanCode();
        this.accountBalance = accountBalance;
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
        this.depositAmount = depositAmount;
        this.withdrawalAmount = withdrawalAmount;
    }

    SecureRandom random = new SecureRandom();
    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public int idGenerator() {
       return  1000 + random.nextInt(9998);
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

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void canDepositCash(double newDeposits) {
        this.accountBalance = (accountBalance + newDeposits) + minimumBalance;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void canWithdrawCash(double newWithdrawals) {
         this.accountBalance = (accountBalance - newWithdrawals) - minimumBalance;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public double getAnnualInterestRate() {
        double annualInterest;
        annualInterest = interestRate * 12;
        return annualInterest;
    }

    public void setDepositAmount(double depositAmount) {
      boolean depositAmountIsValid = depositAmount > 0.0;

      if(depositAmountIsValid){
          this.depositAmount = depositAmount;
          canDepositCash(depositAmount);
      }else{
          System.out.println("Transaction can be Completed");
      }
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getWithdrawalAmount() {
        return  withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        boolean withdrawalAmountIsValid = withdrawalAmount > 0.0;
        boolean depositCashIsSufficient = getBalance() > withdrawalAmount;

        if(withdrawalAmountIsValid && depositCashIsSufficient){
            this.withdrawalAmount = withdrawalAmount;
            canWithdrawCash(withdrawalAmount);
        }else {
            System.out.println("Transaction cannot be Completed");
        }
    }


}
