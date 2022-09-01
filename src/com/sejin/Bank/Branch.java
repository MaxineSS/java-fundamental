package com.sejin.Bank;

import java.util.ArrayList;

public class Branch {
  private String name;
  private ArrayList<Customer> customers;
  /*
    customers = [
      { customer: { name: "", transactions: [] } },
      { customer: { name: "", transactions: [] } },
      { customer: { name: "", transactions: [] } },
    ]
  */
  public Branch(String name) {
    this.name = name;
    this.customers = new ArrayList<Customer>();
  }

  // basic getter
  public String getName() {
    return name;
  }
  public ArrayList<Customer> getCustomers() {
    return customers;
  }

  // add a cusotomer to that branch with initial transaction
  public boolean addNewCustomer(String name, double intialAmount) {

    if(findCustomer(name) != null) {
      System.out.println("Customer name with " + name + " already exists");
      return false;
    } else {
      this.customers.add(new Customer(name, intialAmount));
      System.out.println("Successfully added customer :" + name);
      return true;
    }
  }
  // add a transaction for an existing customer for that branch
  public boolean addCustomerTransaction(String name, Double amount) {
    Customer foundCustomer = findCustomer(name);

    if(foundCustomer != null) {
      foundCustomer.addTransaction(amount);
      return true;
    }
    return false;
  }
  // query customer
  public Customer findCustomer(String name) {
    for (int i = 0; i < this.customers.size(); i++) {
      Customer current = this.customers.get(i);
      if(current.getName() == name) {
        return current;
      }
    }
    return null;
  }


}
