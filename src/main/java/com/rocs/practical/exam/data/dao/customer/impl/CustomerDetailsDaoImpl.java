package com.rocs.practical.exam.data.dao.customer.impl;

import com.rocs.practical.exam.data.connection.ConnectionHelper;
import com.rocs.practical.exam.data.dao.customer.CustomerDetailsDao;
import com.rocs.practical.exam.data.model.customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
    @Override
    public Customer retrieveCustomerInfo() {
        Customer customer = null;
        try (Connection con = ConnectionHelper.getConnection()){

            String sql = "SELECT * FROM CUSTOMERS";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
             customer = new Customer();
             customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
             customer.setName(rs.getString("NAME"));
             customer.setAddress(rs.getString("ADDRESS"));
             customer.setContactNumber(rs.getString("CONTACTNUMBER"));

            }

        }catch ( SQLException ignored) {

        }
        return customer;
    }
}
