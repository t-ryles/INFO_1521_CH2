module com.example.ch13_ex1_futurevalue {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.murach.futurevalue to javafx.fxml;
    exports com.murach.futurevalue;
}