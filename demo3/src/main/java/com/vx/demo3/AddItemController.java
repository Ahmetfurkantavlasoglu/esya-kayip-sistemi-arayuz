package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddItemController {

    @FXML
    private void handleLostItems() {
        // Kaybolan eşya ekranı
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kaybolan Eşyalar");
        alert.setContentText("Kaybolan eşya ekleniyor...");
        alert.showAndWait();
    }

    @FXML
    private void handleFoundItems() {
        // Bulunan eşya ekranı
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bulunan Eşyalar");
        alert.setContentText("Bulunan eşya ekleniyor...");
        alert.showAndWait();
    }

    @FXML
    private void handleAddItem() {
        // Ekle butonuna tıklandığında yeni pencere açılıyor
        Stage addItemStage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane, 300, 200); // Şu an boş bir pencere
        addItemStage.setTitle("Yeni Eşya Ekle");
        addItemStage.setScene(scene);
        addItemStage.show();
    }
}
