package com.groupg.onlinebanking.models;

import java.util.Date;


public class Note {
     
    private Date date;
    private String note;
    
    public Note() {
    }

    public Note(String note) {
        this.date = new Date();
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
