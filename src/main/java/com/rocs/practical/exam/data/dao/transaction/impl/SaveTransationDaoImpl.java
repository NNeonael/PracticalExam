package com.rocs.practical.exam.data.dao.transaction.impl;

import com.rocs.practical.exam.data.connection.ConnectionHelper;
import com.rocs.practical.exam.data.dao.transaction.SaveTransactionDao;
import com.rocs.practical.exam.data.model.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveTransationDaoImpl implements SaveTransactionDao {
    @Override
    public Boolean saveTransaction(Transaction transaction)  {


        try(Connection con = ConnectionHelper.getConnection()){
            String sql = "INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1 ,transaction.getTransactionID());
            stmt.setInt(2,transaction.getCustomerID());
            stmt.setDate(3,transaction.getTransDate());

            int affectedRow = stmt.executeUpdate();

            return affectedRow > 0;

        }catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
}
