package com.sejin.Bank;

import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Double> transactions;
  /*
   transactions = [ { value: }, { value: }, { value: } ]
  */
  public Customer(String name, double intialAmount) {
    this.name = name;
    this.transactions = new ArrayList<Double>();
    addTransaction(intialAmount);
  }

  public void addTransaction(double amount) {
    this.transactions.add(amount);
  }
  // factory method
  public static Customer createCustomer(String name, double intialAmount) {
    return new Customer(name, intialAmount);
  }
  // getter
  public ArrayList<Double> getTransactions() {
    return transactions;
  }

  public String getName() {
    return name;
  }

}
