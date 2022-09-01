package com.sejin.Bank;

import java.util.ArrayList;

public class Bank {
  private String name;
  private ArrayList<Branch> branches;
  /*
    branches = [
     { branch : { name: "", customers: [] } },
     { branch : { name: "", customers: [] } },
     { branch : { name: "", customers: [] } }
    ]
  */

  public Bank(String name) {
    this.name = name;
    this.branches = new ArrayList<Branch>();
  }

  // add new branch
  public boolean addBranch(String name) {
    if(findBranch(name) == null) {
      this.branches.add(new Branch(name));
      return true;
    }
    return false;
  }
  public boolean addCustomer(String branchName, String customerName, double initialAmount) {
    Branch branch = findBranch(branchName);
    if(branch != null) {
        return branch.addNewCustomer(customerName, initialAmount);
    }
    return false;
  }
  public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
    Branch branch = findBranch(branchName);
    if(branch != null) {
        return branch.addCustomerTransaction(customerName, amount);
    }

    return false;
  }
  public Branch findBranch(String name) {
    for (int i = 0; i < this.branches.size(); i++) {
      Branch current = this.branches.get(i);

      if(current.getName() == name) {
        return current;
      }
    }
    return null;
  }

  // show list of customers for a particular branch (optional: list of their transactions)
  public boolean listCustomers(String branchName, boolean showTransactions) {

    Branch found = findBranch(branchName);

    if(found != null) {
      System.out.println("Customer detail for current branch at " + found.getName());
      ArrayList<Customer> customerList = found.getCustomers();

      if(customerList.size() == 0) {
        System.out.printf("%d Customer exists on the list", customerList.size());
      }
      for (int i = 0; i < customerList.size(); i++) {
        Customer current = customerList.get(i);
        System.out.printf("Customer: [%d] %s \n", (i+1), current.getName());

        if(showTransactions) {
          System.out.println("\tTransactions: ");
          ArrayList<Double> transactions = current.getTransactions();

          for (int j = 0; j < transactions.size(); j++) {
            System.out.println("["+ (j+1) +"]" + "\tAmount: "  + transactions.get(j));
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }

}
