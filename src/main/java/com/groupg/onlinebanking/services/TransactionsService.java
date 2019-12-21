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
    
    // Get All Transactions
    public List<Transactions> getAllTransactions() {
        return transactionList;
    }
    
    // Get Transaction
    public Transactions getTransaction(int id) {
        return transactionList.get(id-1);
    }
    
    // Get the balance
//    public Transactions getBalance(Double balance) {
//        Double debit;
//        debit = transactionList.getDebitAmount();
//        return transactionList.get(balance-debit);
//    }
    
    // Create a Transaction
    public Transactions createTransaction(Transactions m) {
	m.setId(transactionList.size() + 1);
        // Update the balance
        //--Date dateAdded = animalList.get(id-1).getDateAdded();
         //Transactions transaction = transactionList.get(id-1);
        // Double balance = transactionList.get(id-1).getBalance();
        //System.out.println("The balance is: "+balance);
//        debit = transactionList.get(id+1).getDebitAmount();
//        if(debit != null){
//          m.setBalance(balance + debit);
//        }   
//        if(balance>=debitAmount)
//        { 
//                balance=balance-debitAmount;
//        }
//        else
//        {
//                System.out.println("Less Balance..Transaction Failed..");
//        }
	transactionList.add(m);
	return m;
    }
    
    // Update a Transaction
    public Transactions updateTransaction(int id, Transactions m) {
       Date dateAdded = transactionList.get(id-1).getDateAdded();
       m.setDateAdded(dateAdded);
       transactionList.set(id-1,m);
       return m;
    }
   
    // Delete a Transaction
    public Transactions deleteTransaction(int id) {
       Transactions transaction = transactionList.get(id-1);
       transactionList.remove(transaction);
       return transaction;
    }
}
