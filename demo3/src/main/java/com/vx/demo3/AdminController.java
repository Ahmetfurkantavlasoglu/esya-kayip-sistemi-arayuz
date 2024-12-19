package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private GridPane itemsGrid;

    @FXML
    private Button addItemButton;

    @FXML
    private void handleLoginButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/Login.fxml"));
            Parent root = loader.load();

            LoginController loginController = loader.getController();
            loginController.setAddItemButton(addItemButton);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Giriş Ekranı");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showLostItems() {
        itemsGrid.getChildren().clear();
        int column = 0;
        int row = 0;
        int maxColumns = 3;

        for (Item item : LostViewController.getLostItems()) {
            ImageView itemImageView = new ImageView(item.getImage());
            itemImageView.setFitHeight(100);
            itemImageView.setFitWidth(100);

            Text itemDetails = new Text("Tür: " + item.getTur() + "\nRenk: " + item.getRenk() + "\nMarka: " + item.getMarka());
            itemDetails.getStyleClass().add("ad-text");

            VBox itemBox = new VBox(itemImageView, itemDetails);
            itemBox.setSpacing(10);

            itemsGrid.add(itemBox, column, row);
            column++;

            if (column == maxColumns) {
                column = 0;
                row++;
            }
        }
    }

    @FXML
    private void showFoundItems() {
        itemsGrid.getChildren().clear();
        int column = 0;
        int row = 0;
        int maxColumns = 3;

        for (Item item : FoundViewController.getFoundItems()) {
            ImageView itemImageView = new ImageView(item.getImage());
            itemImageView.setFitHeight(100);
            itemImageView.setFitWidth(100);

            Text itemDetails = new Text("Tür: " + item.getTur() + "\nRenk: " + item.getRenk() + "\nMarka: " + item.getMarka());
            itemDetails.getStyleClass().add("ad-text");

            VBox itemBox = new VBox(itemImageView, itemDetails);
            itemBox.setSpacing(10);

            itemsGrid.add(itemBox, column, row);
            column++;

            if (column == maxColumns) {
                column = 0;
                row++;
            }
        }
    }

    @FXML
    private void handleAddItem() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vx/demo3/EmptyView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Boş Sayfa");
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

    @FXML
    private void exitApplication() {
        System.exit(0);
    }
}
