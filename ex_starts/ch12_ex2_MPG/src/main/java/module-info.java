module com.example.ch12_ex2_mpg {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ch12_ex2_mpg to javafx.fxml;
    exports com.example.ch12_ex2_mpg;
}