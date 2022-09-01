package com.sejin.Bank;

public class Main {
  public static void main(String[] args) {
    Bank newBank = new Bank("BECU");
    newBank.addBranch("West Seattle");
    newBank.addCustomer("West Seattle", "Jure", 100.78);
    newBank.addCustomer("West Seattle", "Sejin", 209);
    newBank.addCustomer("West Seattle", "Time", 100.89);
    newBank.addCustomer("West Seattle", "Rosie", 50.23);

    newBank.addCustomerTransaction("West Seattle", "Sejin", 25);

    // newBank.listCustomers("West Seattle", false);
    if(!newBank.addBranch("West Seattle")) {
      System.out.println("West Seattle branch already exists");
    }
    if(!newBank.addCustomer("North Seattle", "John", 56)) {
      System.out.println("Error! North Seattle branch does not exist");
    }
    if(!newBank.addCustomerTransaction("West Seattle", "Sarah", 56)) {
      System.out.println("Customer does not exist at this branch");
    }
  }
}
