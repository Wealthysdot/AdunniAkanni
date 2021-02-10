package com;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
        Customer newCustomer;
        Date date;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
@Test
    void test_ThatOurConstructor(){
        date = new Date(1991,12,31);
        newCustomer = new Customer(date);
}
@Test
    void testThatOurConstructorWorks(){
      newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
      int id = newCustomer.getCustomerId();
      String firstName = newCustomer.getFirstName();
      String lastName = newCustomer.getLastName();
      String location = newCustomer.getAddress();
      String gender = newCustomer.getGender();

      assertEquals("Sabo,Yaba", location);
      assertEquals("Nelson",lastName);
      assertEquals("Grace", firstName);
      assertNotEquals(0, id);
      assertEquals("Female", gender);
}

@Test
    void test_ThatThrFirstNameCanBeUpdated(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    newCustomer.setFirstName("Gina");
    assertEquals("Gina",newCustomer.getFirstName());
}
@Test
    void test_ThatTheLastNameCanBeUpdated(){
        newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
        newCustomer.setLastName("Nancy");
        assertEquals("Nancy",newCustomer.getLastName());
    }

@Test
    void testThatCustomerAddressCanBeUpdated(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    newCustomer.setAddress("Orile,Iganmu");
    assertEquals("Orile,Iganmu", newCustomer.getAddress());
}
@Test
    void test_ThatCustomerCanChooseTheirGender(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    newCustomer.setGender("male");
    newCustomer.setGender("female");
    assertEquals("male",newCustomer.getGender());
    assertEquals("female",newCustomer.getGender());
}
@Test
    void testThatCustomerHaveACustomerId(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    int id = Customer.generateId();
    assertNotEquals(0,id);
    assertNotNull(id);
}

@Test
    void test_CustomerCanSetDateOfBirth(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    String date = newCustomer.displayDateOfBirth().toString();
    assertEquals("1991/10/21",date);
}
@Test
    void test_ThatCustomerCanDisplayDetails(){
    newCustomer = new Customer("Grace","Nelson","Sabo,Yaba",1991,10,21,"Female");
    String details =  newCustomer.getCustomerDetails();
    assertEquals("Dear Nelson,Grace your Account has been Created.",details);
}
}