package com.groupg.onlinebanking.models;

import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;


public class Transactions {
    
    private int id;
    private Date dateAdded;
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
        this.description = description;
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
        Double debit = getDebitAmount();
        // Debit the balance which we will return
        // balance = balance - debit;
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
}
