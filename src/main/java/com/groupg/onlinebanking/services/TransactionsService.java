/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupg.onlinebanking.services;

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
    
    Transactions findTransactionByid(int id){    
    for (Transactions transaction : transactionList) {
        if (transaction.getId() == id) {
            return transaction;
        }
    }
        return null; 
    }
    
    // Create a Transaction
    public Transactions createTransaction(Transactions m) {
	m.setId(transactionList.size() + 1);
        // Get the current created transaction account no
        int account = m.getAccountNo(); 
        // Print out the value of the current account no     
        System.out.println("Get AccountNo is: "+account);
        
        System.out.println(transactionList);

        long id = m.getId();
        //System.out.println(findTransactionByid((int) id));

        
        
        
        
        
        
// Update the balance

        if (transactionList.contains(account)) {
            System.out.println("Account found");
            m.setBalance(m.getBalance());
        } else {
            System.out.println("Account not found");
        }

        

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
