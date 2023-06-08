module com.murach.mpg {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.murach.mpg to javafx.fxml;
    exports com.murach.mpg;
}