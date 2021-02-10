package com;

public class Date {
    private int month;
    private int year;
    private int day;

    public Date(int year, int month, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }


    public void setMonth(int newMonth) {
        boolean myMonth = newMonth > 0 && newMonth< 13;
        if(myMonth){
            this.month = newMonth;
        }else
            {
            System.out.println("Invalid month of Birth");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int newYear) {
        boolean myYear = newYear > 1800 && newYear < 9999;
        if(myYear){
            this.year = newYear;
        }else
            {
            System.out.println("Invalid year ");
        }
    }

    public int getYear() {
        return  year;
    }

    public void setDay(int newDay) {
        boolean myDay = newDay > 0 && newDay< 32;
        if(myDay){
            this.day = newDay;
        }else
            { System.out.println("Invalid Day ");
        }
    }

    public int getDay() {
        return  day;
    }

    public String toString() {
     String dateFormat = "";
        dateFormat = year + "/" + month + "/" + day;
     return  dateFormat;
    }
}
