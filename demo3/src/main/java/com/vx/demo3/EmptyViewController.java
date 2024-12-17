package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class EmptyViewController {

    @FXML
    private Button foundButton;

    @FXML
    private Button lostButton;

    // Kaybolan butonuna tıklanınca çalışacak metod
    @FXML
    private void showLostView() {
        Stage currentStage = (Stage) lostButton.getScene().getWindow(); // Mevcut pencereyi al
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/LostView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Kaybedilen Eşyalar");
            stage.setScene(new Scene(root));
            stage.show();

            // Mevcut pencereyi kapatma işlemi
            currentStage.close();
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
        Stage currentStage = (Stage) foundButton.getScene().getWindow(); // Mevcut pencereyi al
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/FoundView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Bulunan Eşyalar");
            stage.setScene(new Scene(root));
            stage.show();

            // Mevcut pencereyi kapatma işlemi
            currentStage.close();
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
