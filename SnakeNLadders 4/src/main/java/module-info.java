module com.example.snakenladders {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakenladders to javafx.fxml;
    exports com.example.snakenladders;
}