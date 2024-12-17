package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

public class EmptyViewController {

    // Kaybedilen butonuna tıklanınca çalışacak metod
    @FXML
    private void showLostView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/LostView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Kaybedilen Eşyalar");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText("Sayfa açılırken bir hata oluştu.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    // Bulunan butonuna tıklanınca çalışacak metod
    @FXML
    private void showFoundView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/FoundView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Bulunan Eşyalar");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText("Sayfa açılırken bir hata oluştu.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
