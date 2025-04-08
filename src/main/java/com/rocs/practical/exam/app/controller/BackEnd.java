package com.rocs.practical.exam.app.controller;

import com.rocs.practical.exam.data.connection.ConnectionHelper;
import com.rocs.practical.exam.data.model.item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BackEnd  implements Initializable {


    @FXML
    private Button AddtoCartButton;

    @FXML
    private Button CheckOutButton;

    @FXML
    private TextField CustomerNameTextField;

    @FXML
    private TextField ItemIDTextField;



    @FXML
    private TextField QuantityTextField;

    @FXML
    private Label ShoppingCartLabel;

    @FXML
    private TextField descriptionTextField;


    @FXML
    private TableColumn<Item, Integer> Item_idColumn;

    @FXML
    private TableColumn<Item, String> itemColumn;

    @FXML
    private TableColumn<Item, Integer> priceColumn;

    @FXML
    private TableColumn<Item, Integer> quantityColumn;

     @FXML

    private TableView<Item> ShoppingCart;
    @FXML
    private TextField textfieldCustID;


    private final ObservableList<Item> cartItems = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
        Item_idColumn.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        showTableOnUi();





        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getCustomerName(){
     String customerID = CustomerNameTextField.getText();

     if(customerID.equals("1")){

     }
    }

    private void onAddToCart() {
        try {
            String itemID = Item_idColumn.getText();
            String description = descriptionTextField.getText();
            int quantity = Integer.parseInt(ItemIDTextField.getText());
             double price = 50.0;

             cartItems.add ( new Item (itemID,description,quantity,price));




        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }




    public ObservableList <Item> testDb() throws SQLException {

    ObservableList<Item> retrieve = FXCollections.observableArrayList();

    try(Connection connection = ConnectionHelper.getConnection()) {

        String sql = "SELECT"+
        "i.ItemID,"+
        "i.Description AS Item,"+
        "i.UnitPrice AS Price,"+
        "ti.Quantity"+
        "FROM Items i"+
        "JOIN"+
        "TransactionItems ti ON i.ItemID = ti.ItemID;";


        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Item item = new Item();
            item.setItemID(resultSet.getInt("ItemID"));
            item.setItemDesc(resultSet.getString("Description"));
            item.setUnitPrice(resultSet.getInt("UnitPrice"));
            item.setQuantity(resultSet.getInt("Quantity"));


            retrieve.add(item);
        }
    }catch (SQLException sqlException)  {

    }

     return retrieve;
    }


    public void showTableOnUi() throws SQLException {
        ObservableList<Item> storeListTable = testDb();
        ShoppingCart.setItems(storeListTable);
    }










}
