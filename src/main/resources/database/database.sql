
create user sco identified by Neonael2004;

alter user sco quota unlimited on DATA;

alter user sco quota unlimited on USERS;

grant create session to sco with admin option;

grant connect to sco;

alter session set current_schema = sco;



drop table Customers cascade constraints;
drop table Item cascade constraints;
drop table Transaction cascade constraints;

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Address VARCHAR2(100),
    ContactNumber VARCHAR2(20)
);

CREATE TABLE Items (
    ItemID NUMBER PRIMARY KEY,
    Description VARCHAR2(100),
    UnitPrice NUMBER(10, 2)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    TransDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE TransactionItems (
    TransactionID NUMBER,
    ItemID NUMBER,
    Quantity NUMBER,
    PRIMARY KEY (TransactionID, ItemID),
    FOREIGN KEY (TransactionID) REFERENCES Transactions(TransactionID),
    FOREIGN KEY (ItemID) REFERENCES Items(ItemID)
);




INSERT INTO Customers (CustomerID, Name, Address, ContactNumber) VALUES (1, 'J. dela Cruz', 'Tagaytay', '09919112223');
INSERT INTO Customers (CustomerID, Name, Address, ContactNumber) VALUES (2, 'A. Ketcum', 'Silang', '0991119219');
INSERT INTO Customers (CustomerID, Name, Address, ContactNumber) VALUES (3, 'G. Vuson', 'Alfonso', NULL);


INSERT INTO Items (ItemID, Description, UnitPrice) VALUES (1, 'Cosoco', 500.00);
INSERT INTO Items (ItemID, Description, UnitPrice) VALUES (2, 'Garderna', 250.00);
INSERT INTO Items (ItemID, Description, UnitPrice) VALUES (3, 'Slick RU', 650.00);


INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES (1, 1, TO_DATE('2024-11-04', 'YYYY-MM-DD'));
INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES (2, 2, TO_DATE('2024-11-04', 'YYYY-MM-DD'));
INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES (3, 1, TO_DATE('2024-12-04', 'YYYY-MM-DD'));


INSERT INTO TransactionItems (TransactionID, ItemID, Quantity) VALUES (1, 1, 2);
INSERT INTO TransactionItems (TransactionID, ItemID, Quantity) VALUES (1, 2, 2);
INSERT INTO TransactionItems (TransactionID, ItemID, Quantity) VALUES (2, 2, 2);
INSERT INTO TransactionItems (TransactionID, ItemID, Quantity) VALUES (3, 3, 3);