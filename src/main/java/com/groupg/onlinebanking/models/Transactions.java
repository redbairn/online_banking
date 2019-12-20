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
    private BigDecimal creditAmount;
    private BigDecimal debitAmount;
    private String colour;
    private List<Note> notes;
    private String functions;
    
    public Transactions() {
    }

    public Transactions(int id, String description, int accountNo, BigDecimal debitAmount, BigDecimal creditAmount, String colour) {
        this.id = id;
        this.dateAdded = new Date();
        this.description = description;
        this.accountNo = accountNo;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.colour = colour;
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
    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }
    
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }
   
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
