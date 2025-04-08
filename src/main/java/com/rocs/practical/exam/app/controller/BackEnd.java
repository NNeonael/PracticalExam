package com.rocs.practical.exam.app.controller;

import com.rocs.practical.exam.data.connection.ConnectionHelper;
import com.rocs.practical.exam.data.model.item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Item, Integer> ItemIDColumn;

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

            //Nothing works po :((
            //having problem displaying po yung sa table sa ui

            getCustomerName();


            ItemIDColumn.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        showTableOnUi();





        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void getCustomerName() {

        String customerID = textfieldCustID.getText();


        if (customerID.isEmpty()) {
            CustomerNameTextField.setText("Please enter a Customer ID.");
            return;
        }

        try {

            int customerIdInt = Integer.parseInt(customerID);
            try (Connection con = ConnectionHelper.getConnection()) {
                String sql = "SELECT Name FROM Customers WHERE CustomerID = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, customerIdInt);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String customerName = rs.getString("Name");

                    CustomerNameTextField.setText(customerName);
                } else {

                    CustomerNameTextField.setText("Customer not found.");
                }

            } catch (SQLException e) {

                e.printStackTrace();
                CustomerNameTextField.setText("Error retrieving data.");
            }

        } catch (NumberFormatException e) {

            CustomerNameTextField.setText("Invalid Customer ID format.");
        }
    }



    private void AddtoCartButton() {
        try {
            String itemID = ItemIDColumn.getText();
            String description = descriptionTextField.getText();
            int quantity = Integer.parseInt(ItemIDTextField.getText());
            int price = getPrice(ItemIDColumn);




        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getPrice(TableColumn<Item, Integer> item)  {
        try(Connection con = ConnectionHelper.getConnection()){
            String sql = "SELECT UnitPrice\n" +
                    "FROM Items\n" +
                    "WHERE ItemID = : ?;\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,item.getId());






        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }




    public ObservableList <Item> displayOnCart() throws SQLException {

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
        ObservableList<Item> storeListTable = displayOnCart();
        ShoppingCart.setItems(storeListTable);
    }










}

