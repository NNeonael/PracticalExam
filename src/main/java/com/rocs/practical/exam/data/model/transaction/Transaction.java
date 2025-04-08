package com.rocs.practical.exam.data.model.transaction;

import java.util.Date;

public class Transaction {
    private int transactionID;
    private int customerID;
    private Date TransDate;


    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public java.sql.Date getTransDate() {
        return (java.sql.Date) TransDate;
    }

    public void setTransDate(Date transDate) {
        TransDate = transDate;
    }
}
