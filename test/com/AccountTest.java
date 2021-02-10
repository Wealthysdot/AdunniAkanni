package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account newAccount;
    LocalDate localDate = LocalDate.now();
    SecureRandom random;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatOurAccountHasAOpeningDate() {
        localDate = LocalDate.now();
        newAccount = new Account(localDate, 0.0);
        assertNotNull(newAccount.getAccountOpeningDate());
        System.out.println(localDate);
    }

    @Test
    void testThatOurAccountHasAnAccountId() {
        localDate = LocalDate.now();
        newAccount = new Account(localDate, 0.0);
        random = new SecureRandom();
        int id = newAccount.idGenerator();
        assertNotEquals(0, id);
        assertNotNull(newAccount.getAccountId());
    }

    @Test
    void testAccountHasCanGenerateAccountNumber() {
        newAccount = new Account(localDate, 0.0);
        random = new SecureRandom();
        int generator = newAccount.nubanGenerator();
        assertNotEquals(0, generator);
        System.out.println(generator);
    }

    @Test
    void testThatAccountHasAccountStartingNubanNumber() {
        newAccount = new Account(localDate, 0.0);
        newAccount.nubanCode();
        assertNotNull(newAccount.getNubanNumber());
    }

    @Test
    void testThatAccountHasANInitialBalance() {
        newAccount = new Account(localDate, 0.0);
        double balance = newAccount.hasMinimumBalance();
        assertEquals(0.0, balance);
        System.out.println(balance);
    }

    @Test
    void testThatAccountCanReceivedCash() {
        newAccount = new Account(localDate, 0.0);
        newAccount.canDepositCash(2000.0);
        assertEquals(2000.0, newAccount.getBalance());
    }

    @Test
    void testThatAccountCanWithdrawCash() {
        newAccount = new Account(localDate, 0.0);
        newAccount.canDepositCash(40000.0);
        newAccount.canWithdrawCash(30000);
        newAccount.canWithdrawCash(40000);
        assertEquals(5000.0, newAccount.getBalance());
    }
}
