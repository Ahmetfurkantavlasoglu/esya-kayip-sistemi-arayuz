package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private GridPane itemsGrid;

    @FXML
    private Button loginButton;

    @FXML
    private Button addItemButton;

    private boolean isLoggedIn = false;

    @FXML
    private void handleLoginButton() {
        // Giriş penceresini oluştur
        Stage loginStage = new Stage();
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.setTitle("Admin Girişi");

        Label usernameLabel = new Label("Kullanıcı Adı:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Şifre:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Giriş Yap");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Kullanıcı adı ve şifre kontrolü
            if (username.equals("admin") && password.equals("1234")) {
                isLoggedIn = true;
                Alert loginAlert = new Alert(Alert.AlertType.INFORMATION, "Giriş Başarılı!");
                loginAlert.showAndWait();
                loginStage.close();
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Hatalı kullanıcı adı veya şifre!");
                errorAlert.showAndWait();
            }
        });

        GridPane loginLayout = new GridPane();
        loginLayout.setVgap(10);
        loginLayout.setHgap(10);
        loginLayout.add(usernameLabel, 0, 0);
        loginLayout.add(usernameField, 1, 0);
        loginLayout.add(passwordLabel, 0, 1);
        loginLayout.add(passwordField, 1, 1);
        loginLayout.add(loginButton, 1, 2);

        Scene loginScene = new Scene(loginLayout, 300, 200);
        loginStage.setScene(loginScene);
        loginStage.showAndWait();
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

            Label itemDetails = new Label("Tür: " + item.getTur() + "\nRenk: " + item.getRenk() + "\nMarka: " + item.getMarka());

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

            Label itemDetails = new Label("Tür: " + item.getTur() + "\nRenk: " + item.getRenk() + "\nMarka: " + item.getMarka());

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
        if (!isLoggedIn) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Giriş yapılmadı!");
            alert.showAndWait();
            return;
        }

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
