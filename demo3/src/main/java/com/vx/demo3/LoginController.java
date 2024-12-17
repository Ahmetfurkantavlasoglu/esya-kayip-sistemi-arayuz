package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public Button kspfdo;

    @FXML
    private void handleLoginButton() {
        // Giriş işlemleri
        Alert loginAlert = new Alert(Alert.AlertType.INFORMATION, "Giriş ekranı açıldı.");
        loginAlert.showAndWait();
    }

    @FXML
    private void handleRegisterButton() {
        // Kayıt işlemleri
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField phoneField = new TextField();

        usernameField.setPromptText("Kullanıcı Adı");
        passwordField.setPromptText("Şifre");
        phoneField.setPromptText("Telefon Numarası");

        Alert registerAlert = new Alert(Alert.AlertType.INFORMATION);
        registerAlert.setTitle("Kayıt Ol");
        registerAlert.setHeaderText(null);
        registerAlert.setContentText("Kullanıcı Adı: " + usernameField.getText() + "\nŞifre: " + passwordField.getText() + "\nTelefon Numarası: " + phoneField.getText());
        registerAlert.getDialogPane().setContent(phoneField);

        registerAlert.showAndWait();
    }
}