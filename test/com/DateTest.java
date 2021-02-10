package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    Date newDate;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void test_ThatDateHasAMonth(){
        newDate = new Date(1991,10,21);
        newDate .setMonth(12);
        newDate .setMonth(13);
        assertEquals(12,newDate .getMonth());
    }

    @Test
    void test_ThatDateHasAYear(){
        newDate = new Date(1991,10,21);
        newDate.setYear(2020);
        newDate.setYear(32);
        assertEquals(2020,newDate.getYear());
    }
    @Test
    void test_ThatDateHasADay(){
        newDate = new Date(1991,10,21);
        newDate.setDay(20);
        newDate.setDay(32);
        assertEquals(20,newDate.getDay());
    }
@Test
    void test_DateToString(){
        newDate = new Date(1991,10,21);
        newDate.setYear(1992);
        newDate.setMonth(10);
        newDate.setDay(21);
        String date = newDate.toString();
        assertEquals("1992/10/21",date);
}
}