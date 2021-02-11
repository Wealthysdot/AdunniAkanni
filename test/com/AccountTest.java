package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account newAccount;
    LocalDate localDate;
    SecureRandom random;


    @BeforeEach
    void setUp() {
        localDate = LocalDate.now();
        random = new SecureRandom();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatOurAccountHasAOpeningDate() {
        localDate = LocalDate.now();
        newAccount = new Account(0.0,0.0,0.0,localDate, 0.0,0.0);
        assertNotNull(newAccount.getAccountOpeningDate());
        System.out.println(localDate);
    }

    @Test
    void testThatOurAccountHasAnAccountId() {
        localDate = LocalDate.now();
        newAccount = new Account(0.0,0.0,0.0,localDate, 0.0,0.0);
        random = new SecureRandom();
        int id = newAccount.idGenerator();
        assertNotEquals(0, id);
        assertNotNull(newAccount.getAccountId());
        System.out.println(id);
    }

    @Test
    void testAccountHasCanGenerateAccountNumber() {
        newAccount = new Account(0.0,0.0,0.0,localDate, 0.0,0.0);
        random = new SecureRandom();
        int generator = newAccount.nubanGenerator();
        assertNotEquals(0, generator);
        System.out.println(generator);
    }

    @Test
    void testThatAccountHasAccountStartingNubanNumber() {
        newAccount = new Account(0.0,0.0,0.0,localDate, 0.0,0.0);
        newAccount.nubanCode();
        assertNotNull(newAccount.getNubanNumber());
        System.out.println(newAccount.getNubanNumber());
    }

    @Test
    void testThatAccountHasANInitialBalance() {
        newAccount = new Account(0.0,0.0,0.0,localDate, 0.0,0.0);
        double balance = newAccount.getMinimumBalance();
        assertEquals(0.0, balance);
        System.out.println(balance);
    }

    @Test
    void testThatAccountCanReceivedCash() {
        newAccount = new Account(0.0,0.0,1000.0,localDate, 0.0,0.0);
        newAccount.canDepositCash(2000.0);
        assertEquals(3000.0, newAccount.getBalance());
    }

    @Test
    void testThatAccountCanWithdrawCash() {
        newAccount = new Account(0.0,0.0,1000.0,localDate, 0.0,0.0);
        newAccount.canDepositCash(40000.0);
        newAccount.canWithdrawCash(38000);
        newAccount.canWithdrawCash(40000);
        assertEquals(2000.0, newAccount.getBalance());
    }
    @Test
    void testThatAnAccountHasADefaultInterestRate(){
        newAccount = new Account(0.0,0.0,0.0,localDate,0.0,0.0);
        double rate = newAccount.getInterestRate();
        assertEquals(0.0,rate);
    }


    @Test
    void testThatAnAccountCanGenerateAnAnnualInterestRate(){
        newAccount = new Account(0.0,0.0,0.0,localDate,0.0,0.0);
        double annual = newAccount.getAnnualInterestRate();
        assertEquals(0.0,annual);
    }

    @Test
    void testThat_AccountCanValidateIts_DepositAmountBeforeDeposition(){
        newAccount = new Account(0.0,0.0,1000.0,localDate,5000.0,0.0);
        newAccount.setDepositAmount(4000.0);
        assertEquals(4000.0,newAccount.getDepositAmount());
        assertEquals(10000.0,newAccount.getBalance());
        System.out.println(newAccount.getDepositAmount());
    }
    @Test
    void testThat_AccountCanCaptureIts_DepositAmountBeforeDeposition(){
        newAccount = new Account(0.0,0.0,1000.0,localDate,5000.0,0.0);
        newAccount.setDepositAmount(44000.0);
        double depositAmount = newAccount.getDepositAmount();
        assertEquals(44000.0,depositAmount);
        assertEquals(50000.0,newAccount.getBalance());
        System.out.println(depositAmount);
    }
    @Test
    void testThat_AccountCanCaptureIts_WithdrawalAmountBeforeWithdrawn(){
        newAccount = new Account(0.0,0.0,1000.0,localDate,5000.0,0.0);
        double withdrawalAmount = newAccount.getWithdrawalAmount();
        assertEquals(0.0,withdrawalAmount);
    }
    @Test
    void testThat_AccountCanValidateIts_WithdrawalAmountBeforeWithdrawn(){
        newAccount = new Account(0.0,0.0,1000.0,localDate,5000.0,0.0);
        newAccount.setDepositAmount(40000.0);
        newAccount.setWithdrawalAmount(40000.0);
        assertEquals(40000.0,newAccount.getWithdrawalAmount());
        assertEquals(40000.0,newAccount.getDepositAmount());
        assertEquals(5000.0,newAccount.getBalance());
    }
}
