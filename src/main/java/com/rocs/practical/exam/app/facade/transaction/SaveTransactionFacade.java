package com.rocs.practical.exam.app.facade.transaction;

import com.rocs.practical.exam.data.model.transaction.Transaction;

public interface SaveTransactionFacade {
    Boolean saveTransaction(Transaction transaction);
}
