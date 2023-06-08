module com.example.ch13_ex2_pizzaorder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ch13_ex2_pizzaorder to javafx.fxml;
    exports com.example.ch13_ex2_pizzaorder;
}