package com.rocs.practical.exam.data.dao.item.impl;

import com.rocs.practical.exam.data.connection.ConnectionHelper;
import com.rocs.practical.exam.data.dao.item.ItemDetailsDao;
import com.rocs.practical.exam.data.model.customer.Customer;
import com.rocs.practical.exam.data.model.item.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDetailsDaoImpl implements ItemDetailsDao {
    @Override
    public Item retrieveItemDetails() {
        Item item = null;

        try (Connection con = ConnectionHelper.getConnection()){

            String sql = "SELECT * FROM ITEM";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                item = new Item();
                item.setItemDesc(rs.getString("ITEM_DESC"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setUnitPrice(rs.getInt("UNIT_PRICE"));

            }

        }catch  (SQLException e){
            throw new RuntimeException(e);
        }
        return item;
    }
}
