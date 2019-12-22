/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupg.onlinebanking.services;

import com.groupg.onlinebanking.models.Note;
import com.groupg.onlinebanking.models.Transactions;
import com.groupg.onlinebanking.databases.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TransactionsService {
          
    Database d = new Database();
    private List<Transactions> transactionList = d.getTransactionsDB();
    
    // getAllAnimals
    public List<Transactions> getAllTransactions() {
        return transactionList;
    }
    
    // getAnimal
    public Transactions getTransaction(int id) {
        return transactionList.get(id-1);
    }
    
    // createAnimal
    public Transactions createTransaction(Transactions m) {
	m.setId(transactionList.size() + 1);
	transactionList.add(m);
	return m;
    }
    
    // Lodgement Transaction (Credit)
      public Transactions lodgementTransaction(Transactions m) {
        // Need to check if the account number already exists in the transactions table, if it does we need to add the lodgement (credit) value to the original balance
        // First we need to set the accountNo that we are currently using in the lodgement form:
        int account = m.getAccountNo();
        System.out.println("The accountNo from the lodgement form is: "+account); // For testing to see the currently set accountNo
        boolean contains = m.contains(account); // Getting whether the account exists already from the contains method under Transactions.java
        // Below we display in console whether the account exists or not
        if(contains==true){
            System.out.println("This account exists in the database.");
            Double balance = m.getBalance(); // This is only for this balance -- Need to check for the balance of the same account in the database
            //Double newBalance;
            m.setBalance(balance);
            System.out.println("The current balance is: "+balance);

        }else{
            System.out.println("This account doesn't exist in the database!");
            
        }
        //System.out.println("This account exists: "+contains);
        
        // -- m.setBalance();
        // -- m.lodgement(debitAmount);
        // ---Double creditAmount = transactionList.get(id-1).getCreditAmount();
        // ---m.lodgement(debitAmount);
        // 
        
        // Set the transaction, incremented
        m.setId(transactionList.size() + 1);
        // Add the transaction details to the arraylist, transactionList
        transactionList.add(m);
        
        return m;
    }
    
    // Withdraw Transaction (Debit)
      public Transactions withdrawalTransaction(int id, Transactions m) {
	m.setId(transactionList.size() + 1);
        Double debitAmount = transactionList.get(id-1).getDebitAmount();
	m.withdraw(debitAmount);
        transactionList.add(m);
        return m;
    }
    
    //updateAnimal
    public Transactions updateTransaction(int id, Transactions m) {
       Date dateAdded = transactionList.get(id-1).getDateAdded();
       m.setDateAdded(dateAdded);
       transactionList.set(id-1,m);
       return m;
    }
   
    // deleteAnimal
    public Transactions deleteTransaction(int id) {
       Transactions transaction = transactionList.get(id-1);
       transactionList.remove(transaction);
       return transaction;
    }
}
