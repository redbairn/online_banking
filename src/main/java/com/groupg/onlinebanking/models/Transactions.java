package com.groupg.onlinebanking.models;

import com.groupg.onlinebanking.databases.Database;
import static com.groupg.onlinebanking.databases.Database.transactionsDB;
import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;


public class Transactions {
    // Method to check whether the account exists in the transactionsDB
     public boolean contains(int account) {
        Database d = new Database();
        List<Transactions> transactionList = d.getTransactionsDB();

        // Test to print out accountNo's
        for(Transactions transactions : transactionList) {
            System.out.println(transactions.getBalance());  
            if(transactions.getAccountNo() == accountNo){
                balance = transactions.getBalance();
                System.out.println("The balance of the accountNo in the database is: "+balance);
                double newBalance = balance + creditAmount;
                 System.out.println("The new balance of the accountNo ("+accountNo+") in the database is: "+newBalance);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    private int id;
    private Date dateAdded;
//    private String name;
    private String description;
    private int accountNo;
    private Double creditAmount;
    private Double debitAmount;
    private Double balance;
    private List<Note> notes;
    private String functions;
    
    public Transactions() {
    }

    public Transactions(int id, String description, int accountNo, Double debitAmount, Double creditAmount, Double balance) {
        this.id = id;
        this.dateAdded = new Date();
//        this.name = name; need to add this to the database struture
        this.description = description; // should be using this field to reference the transaction once the name field is added to the db, could link this to the note service either 
        this.accountNo = accountNo;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.balance = balance;
        this.notes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateadded) {
        this.dateAdded = dateadded;
    }
// the below needs to be uncommented to be added to the database structure    
//    public String getName() {
//        return name;
//    }
//    
//    public void setName() {
//        this.name = name;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }
    
    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }
   
    public Double getBalance() {
//        if(balance > 0){
//            creditAmount = getCreditAmount();
//            balance = balance + creditAmount;
//        }
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public List<Note> getNotes() {
	return notes;
    }

    public void setNotes(List<Note> note) {
	this.notes = notes;
    }
    
    public Note addNote(String noteText) {
        Note note = new Note (noteText);  
        this.notes.add(note);
        return note;
    }
    
//    public String getFunctions() {
//        functions = "<div class='function_buttons'><ul>";
//        functions += "<li class='function_edit'><a data-id='"+id+" 'data-name='"+accountNo+"'><span>Edit</span></a></li>";
//        functions += "<li class='function_delete'><a data-id='"+id+" 'data-name='"+accountNo+"'><span>Delete</span></a></li>";
//        functions += "</ul></div>";
//        return functions;
//    }
    
    private void setFunctions(String functions) {
        // dummy setter 
    }
    
    
    public void withdraw(double debitAmount) {
        balance = balance - debitAmount;
        setBalance(balance);
    }

    public void lodgement(double creditAmount) {
        balance = balance + creditAmount;
        setBalance(balance);
    } 
}
