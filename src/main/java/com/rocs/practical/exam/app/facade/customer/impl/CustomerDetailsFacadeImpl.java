package com.rocs.practical.exam.app.facade.customer.impl;

import com.rocs.practical.exam.PracticalExam;
import com.rocs.practical.exam.app.facade.customer.CustomerDetailsFacade;
import com.rocs.practical.exam.data.dao.customer.CustomerDetailsDao;
import com.rocs.practical.exam.data.dao.customer.impl.CustomerDetailsDaoImpl;
import com.rocs.practical.exam.data.model.customer.Customer;

public class CustomerDetailsFacadeImpl implements CustomerDetailsFacade {

   private CustomerDetailsDao customerDetailsDao = new CustomerDetailsDaoImpl();

    @Override
    public Customer getCustomerInfo() {
      return this.customerDetailsDao.retrieveCustomerInfo();


    }
}
