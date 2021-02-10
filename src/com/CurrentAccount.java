package com;

import java.time.LocalDate;

public class CurrentAccount extends Account {
    public CurrentAccount(LocalDate accountOpeningDate, double accountBalance) {
        super(accountOpeningDate, accountBalance);
    }
}
