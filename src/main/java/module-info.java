module com.example.gui22022 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui22022 to javafx.fxml;
    exports com.example.gui22022;
}