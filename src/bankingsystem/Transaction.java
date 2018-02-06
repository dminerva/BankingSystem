/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.Date;

/**
 *
 * @author 123
 */
public class Transaction {
    private int transactionID;
    private int to;
    private int from;
    private double amount;
    private Date date;

    public Transaction(int transactionID, int to, int from, double amount, Date date) {
        this.transactionID = transactionID;
        this.to = to;
        this.from = from;
        this.amount = amount;
        this.date = date;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", to=" + to + ", from=" + from + ", amount=" + amount + ", date=" + date + '}';
    }
}