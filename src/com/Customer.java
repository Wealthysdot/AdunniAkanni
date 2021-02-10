package com;

import java.security.SecureRandom;


public class Customer {

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private int customerId;
    private Date dateOfBirth;


    public Customer(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;

    }
    public Customer(String firstName, String lastName, String address,int year,int month,int day,
                  String gender) {
        this.customerId = generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = new Date(year,month,day);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return  lastName;
    }

    public String getAddress() {
        return address;
    }
    public String getGender() {
        return gender;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public int getCustomerId() {
        return customerId;
    }

    static int generateId() {
        SecureRandom random = new SecureRandom();
        return 1000 + random.nextInt(9999);
    }

    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setGender(String newGender) {
        if(newGender.equals("f") ||(newGender.equals("F")
                || (newGender.equals("female")|| newGender.equals("Female")))){
            this.gender = "female";
        }else
        { if(newGender.equals("m")||(newGender.equals("M")
                || (newGender.equals("male") || (newGender.equals("Male"))))){
            this.gender = "male";
        }else{
            this.gender = "Non-Binary";
        }
        }
    }
    public Date displayDateOfBirth() {
        return dateOfBirth;
    }

    public String getCustomerDetails() {
        return "Dear " + lastName + "," + firstName +
                " your Account has been Created.";
    }
}
