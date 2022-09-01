package com.sejin.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    LinkedList<String> placesToVisit = new LinkedList<String>();
    addInOrder(placesToVisit, "Seattle"); // expected output [Arizona, Califonia, Seattle, Texas]
    addInOrder(placesToVisit, "Arizona");
    addInOrder(placesToVisit, "Califonia");
    addInOrder(placesToVisit, "Texas");

    printList(placesToVisit);
    visit(placesToVisit);
  }
  private static void visit(LinkedList cities) {
    try (Scanner scanner = new Scanner(System.in)) {
      boolean goingFoward = true;
      boolean quit = false;
      ListIterator<String> list = cities.listIterator();

      if(cities.isEmpty()) {
        System.out.println("No cities in the inteneray");
        return;
      } else {
        printMenu();
        // System.out.println("Now visiting " + list.next() + ", "+ "Previously visited " + list.previous());
      }

      while(!quit) {
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
          case 0:
            System.out.println("Holiday (Vacation) over");
            quit = true;
            break;

          case 1:
            if(!goingFoward) {
              if(list.hasNext()) {
                list.next();
                goingFoward = true;
              }
            }
            if(list.hasNext()) {
              System.out.println("Now visiting " + list.next());
            } else {
              System.out.println("Reached the end of the list");
              goingFoward = false;
            }
            break;

          case 2:
            if(goingFoward) {
              if(list.hasPrevious()) {
                list.previous();
              }
              goingFoward = false;
            }
            if(list.hasPrevious()) {
              System.out.println("Now visiting " + list.previous());
            } else {
              System.out.println("We are at the start of list");
              goingFoward = true;
            }
            break;

          case 3:
            printMenu();
            break;
        }
      }
    } catch (Exception e) {
      System.out.println("Erro message" + e);
    }
  }
  private static void printMenu() {
    System.out.println("Available actions:\npress ");
    System.out.println(
            "0 - to quit\n" +
            "1 - go to next city\n" +
            "2 - go to previous city\n" +
            "3 - print menu options");
  }

  private static void printList(LinkedList<String> itenary) {
    Iterator<String> i = itenary.iterator(); // no prev property - singliy linked list

    while(i.hasNext()) {
      System.out.println("Now visiting " + i.next());
    }
  }
  private static boolean addInOrder(LinkedList<String> destinations, String newCity) {
    ListIterator<String> i = destinations.listIterator(); // yes prev property - doubly linked list

    while(i.hasNext()) {
      int comparison = i.next().compareTo(newCity);

      if(comparison == 0) {
        // do not add
        System.out.println(newCity + " is already included as a destination");
        return false;
      } else if(comparison > 0) {
        // newCity should appear before
        i.previous();
        i.add(newCity);
        return true;
      } else if(comparison < 0) {
        // items in order, move on next
      }
    }
    i.add(newCity);
    return true;
  }

}

  /*
  Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. value -1 < 0(equal) < 1
  */