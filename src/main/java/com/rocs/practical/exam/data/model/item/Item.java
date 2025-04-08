package com.rocs.practical.exam.data.model.item;

public class Item {
    private int itemID;
    private String description;
    private String itemDesc;
    private int unitPrice;
    private int quantity;

    public Item(String itemID, String description, int quantity, double price) {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public int getUnitPrice() {
        return unitPrice;
    }



    public Item() {
    }

    public String getItem() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
