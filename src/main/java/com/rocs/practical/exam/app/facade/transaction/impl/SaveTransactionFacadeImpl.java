package com.rocs.practical.exam.app.facade.transaction.impl;

import com.rocs.practical.exam.app.facade.transaction.SaveTransactionFacade;
import com.rocs.practical.exam.data.dao.transaction.SaveTransactionDao;
import com.rocs.practical.exam.data.dao.transaction.impl.SaveTransationDaoImpl;
import com.rocs.practical.exam.data.model.transaction.Transaction;

public class SaveTransactionFacadeImpl implements SaveTransactionFacade {
    private SaveTransactionDao saveTransactionDao = new SaveTransationDaoImpl();
    @Override
    public Boolean saveTransaction(Transaction transaction) {
        return saveTransactionDao.saveTransaction(transaction);
    }
}
