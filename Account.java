package Bank;

import java.util.Scanner;
import java.util.UUID;

public class Account {
   int balance;
   int previousTransaction;
   String customerName;
   String customerId = UUID.randomUUID().toString().toUpperCase();

   // constructor
   Account(String cname) {
      customerName = cname;
   }

   // add money to the account
   void deposit(int amount) {
      if (amount != 0) {
         balance = balance + amount;
         previousTransaction = amount;
      }
   }

   // withdraw money from the account
   void withdraw(int amount) {
      if (amount != 0) {
         balance = balance - amount;
         previousTransaction = -amount;
      }
   }

   // show the last transaction
   void showPreviousTransaction() {
      if (previousTransaction > 0) {
         System.out.println("Deposited: " + previousTransaction);
      } else if (previousTransaction < 0) {
         System.out.println("withdraw: " + Math.abs(previousTransaction));

      } else {
         System.out.println("No transaction occured");
      }
   }

   // calculate interst
   void calculateIntrest(int years) {
      double intrestRate = 0.185;
      double newBalance = (balance * intrestRate * years) + balance;
      System.out.println("The current intrest rate is " + (100 * intrestRate) + "%");
      System.out.println("Affter " + years + " years, your balance will be: " + newBalance);
   }

   // display the menu of all operations
   void showMenu() {
      char option;
      Scanner scanner = new Scanner(System.in);
      System.out.println("welcome, " + customerName + "!");
      System.out.println("your ID is:  " + customerId);
      System.out.println();
      menu();
      do {
         System.out.println();
         System.out.println("Enter an option: ");
         // input a letter
         char option1 = scanner.next().charAt(0);
         option = Character.toUpperCase(option1);
         System.out.println();
         switch (option) {
            // check the balance option
            case 'A':
               System.out.println("-----------------------");
               System.out.println("Balance = $" + balance);
               System.out.println("-----------------------");
               System.out.println();
               break;
            // make the deposite transaction
            case 'B':
               System.out.println("Enter the amout to deposit: ");
               int depositeAmount = scanner.nextInt();
               deposit(depositeAmount);
               System.out.println();
               break;
            // make the withdraw transaction
            case 'C':
               System.out.println("Enter an amount to withdraw: ");
               int withdrawAmount = scanner.nextInt();
               withdraw(withdrawAmount);
               System.out.println();
               break;
            // show last transaction
            case 'D':
               System.out.println("---------------------");
               showPreviousTransaction();
               System.out.println("---------------------");
               System.out.println();
               break;
            case 'E':
               // intrests calculated within the number of years
               System.out.println("Enter how many years of accrued intrest");
               int years = scanner.nextInt();
               calculateIntrest(years);
               break;
            // print menu
            case 'P':
               System.out.println();
               System.out.println("----------------------");
               System.out.println("----------------------");
               menu();
               break;
            // exit
            case 'F':
               System.out.println("---------------exit");
               break;
            default:
               System.out.println("Error: invalid option. please enter a valid optio!");
               System.out.println();
               menu();
               break;
         }

      } while (option != 'F');
      scanner.close();
      System.out.println("thank you for your visite!");
   }

   // print options list
   void menu() {
      System.out.println("what would you like to do!");
      System.out.println();
      System.out.println("A  Check your balance");
      System.out.println("B  Make a deposite");
      System.out.println("C  Make a withdraw");
      System.out.println("D  View the previous transaction");
      System.out.println("E  Calculate intrest");
      System.out.println("F  Exit");
      System.out.println("P  Review the options list");
   }

}
