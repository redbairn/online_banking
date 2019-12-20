/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupg.onlinebanking.services;

import com.groupg.onlinebanking.models.Transactions;
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
        System.out.println("In the TransactionsService on Line 23");
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
