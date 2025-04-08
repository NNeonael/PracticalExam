package com.rocs.practical.exam.app.facade.item.impl;

import com.rocs.practical.exam.app.facade.item.ItemDetailsFacade;
import com.rocs.practical.exam.data.dao.item.ItemDetailsDao;
import com.rocs.practical.exam.data.dao.item.impl.ItemDetailsDaoImpl;
import com.rocs.practical.exam.data.model.item.Item;

public class ItemDetailsFacadeImpl implements ItemDetailsFacade {
    private ItemDetailsDao itemDetailsDao = new ItemDetailsDaoImpl();
    @Override
    public Item getItemDetails() {
        return this.itemDetailsDao.retrieveItemDetails();
    }
}
