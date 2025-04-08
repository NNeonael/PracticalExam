module org.rocs.practicalexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.rocs.practical.exam to javafx.fxml;
    opens com.rocs.practical.exam.app.controller to javafx.fxml;
    opens com.rocs.practical.exam.data.model.item to javafx.fxml;
    opens com.rocs.practical.exam.data.model.customer to javafx.fxml;
    opens com.rocs.practical.exam.data.model.transaction to javafx.fxml;

    exports com.rocs.practical.exam.app.controller;
    exports com.rocs.practical.exam.data.model.customer;
    exports com.rocs.practical.exam.data.model.item;
    exports com.rocs.practical.exam.data.model.transaction;
    exports com.rocs.practical.exam;
}