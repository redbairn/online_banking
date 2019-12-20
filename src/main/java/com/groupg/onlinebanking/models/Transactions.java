package com.groupg.onlinebanking.models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;


public class Transactions {
    
    private int id;
    private Date dateAdded;
    private String description;
    private int accountNo;
    private String species;
    private String breed;
    private String colour;
    private List<Note> notes;
    private String functions;
    
    public Transactions() {
    }

    public Transactions(int id, String description, int accountNo, String species, String breed, String colour) {
        this.id = id;
        this.dateAdded = new Date();
        this.description = description;
        this.accountNo = accountNo;
        this.species = species;
        this.breed = breed;
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
    
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }    
    
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
