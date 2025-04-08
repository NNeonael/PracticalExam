package com.rocs.practical.exam.data.dao.transaction;

import com.rocs.practical.exam.data.model.transaction.Transaction;

import java.sql.SQLException;

public interface SaveTransactionDao {

 Boolean saveTransaction(Transaction transaction) ;
}
