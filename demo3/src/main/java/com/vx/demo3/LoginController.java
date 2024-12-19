package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private Button addItemButton;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("admin".equals(username) && "1234".equals(password)) {
            // Ekle butonunu aktif hale getir
            addItemButton.setDisable(false);

            // Giriş ekranını kapat
            usernameField.getScene().getWindow().hide();
        } else {
            Alert failureAlert = new Alert(Alert.AlertType.ERROR, "Geçersiz kullanıcı adı veya şifre.");
            failureAlert.showAndWait();
        }
    }

    public void setAddItemButton(Button addItemButton) {
        this.addItemButton = addItemButton;
    }
}
