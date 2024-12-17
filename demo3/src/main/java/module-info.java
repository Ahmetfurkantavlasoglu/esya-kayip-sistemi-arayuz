module com.vx.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.desktop;


    opens com.vx.demo3 to javafx.fxml;
    exports com.vx.demo3;
}