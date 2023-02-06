package Bank;

import java.util.UUID;

public class Bank {
   public static void main(String[] args) {
      // create a new Account
      Account aliAccount = new Account("Ali", UUID.randomUUID().toString());
      aliAccount.showMenu();
   }
}
