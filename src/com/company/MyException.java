package com.company;

public class MyException extends Throwable {
    public void myException(){
        System.out.println("Write only numbers");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    public void myExceptionCloseProgram(){
        System.out.println("Program is closed!");

    }
    public void myExceptionNoMatches(){
        System.out.println("your input is not suitable");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    public void myExceptionDataBasaIsImpty(){
        System.out.println("Data base is empty");
        System.out.println("---------------------------------------------------------------------------------------------------");
    }





}
