/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupg.onlinebanking.databases;

import com.groupg.onlinebanking.models.Note;
import com.groupg.onlinebanking.models.Transactions;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Transactions> transactionsDB = new ArrayList<>();
    public static boolean init = true;
     
    // Lets create a constructor for the class
    public Database () {
      if (init) {
          
        Transactions a1 = new Transactions(1,"Jack", 12345, "Dog","Jack Russell","Tan and white");
        a1.addNote("Note for animal 1");
        transactionsDB.add(a1);
        Transactions a2 = new Transactions(2,"Cindy", 54321, "Dog","Border Collie","Black and white");   
        a2.addNote("Feed every 3 hours");
        a2.addNote("Vets visit on Friday");
        transactionsDB.add(a2);
        Transactions a3 = new Transactions(3,"Mollie", 11223, "Cat","European","Tabby");
        a3.addNote("Found straying on main road");
        transactionsDB.add(a3);
        Transactions a4 = new Transactions(4,"Susie", 22334, "Cat","Siamese","Chocolate");
        a4.addNote("Surrendered");
        transactionsDB.add(a4);
        Transactions a5 = new Transactions(5,"Brandy", 33445 ,"Dog","Welsh Collie","Black");
        transactionsDB.add(a5);
        Transactions a6 = new Transactions(6,"Micha", 44556, "Cat","European","Grey");
        transactionsDB.add(a6);
        init = false;
      }
    }
    
    public static List<Transactions> getTransactionsDB() {
        return transactionsDB;
    }
    
}
