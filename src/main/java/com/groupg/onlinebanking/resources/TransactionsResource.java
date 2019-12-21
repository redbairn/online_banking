package com.groupg.onlinebanking.resources;

import com.groupg.onlinebanking.models.Transactions;
import com.groupg.onlinebanking.services.TransactionsService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionsResource {
    
    TransactionsService transactionService = new TransactionsService();
  
    @GET
    @Path("/transactions")
    public List<Transactions> getTransactions() {
        System.out.println("Getting transactions...");
        List<Transactions> transactionList = transactionService.getAllTransactions();
        return transactionList;
    }
    
    @GET
    @Path("/transaction/{transactionId}")
    public Transactions getTransaction(@PathParam("transactionId") int id) {
        System.out.println("Getting transaction with ID="+id);
        return transactionService.getTransaction(id);
    }
    
    @PUT
    @Path("/transaction/{transactionId}")
    public Transactions setTransaction(@PathParam("transactionId") int id, Transactions m) {
        System.out.println("Updating transaction with ID="+id);
        return transactionService.updateTransaction(id,m);
    }

    // int id, Double balance, Double debit, Transactions m
    @POST
    @Path("/transaction")
    public Transactions postTransaction(Transactions m) {
        m.setDateAdded(new Date());
        System.out.println("Creating new transaction");
	return transactionService.createTransaction(m);
    }
    
    @DELETE 
    @Path("/transaction/{transactionId}")
    public Transactions deleteTransaction(@PathParam("transactionId") int id) {
        System.out.println("Deleting transaction "+id);
	Transactions transaction = transactionService.deleteTransaction(id);
        return transaction;
    }
}
