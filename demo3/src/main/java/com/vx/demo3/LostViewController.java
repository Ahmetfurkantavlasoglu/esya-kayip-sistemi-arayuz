package com.vx.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LostViewController {

    @FXML
    private ImageView imageView;
    @FXML
    private TextField turField;
    @FXML
    private TextField renkField;
    @FXML
    private TextField markaField;

    private static List<Item> lostItems = new ArrayList<>();

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getGestureSource() != imageView && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void handleDragDropped(DragEvent event) {
        var dragboard = event.getDragboard();
        if (dragboard.hasFiles()) {
            File file = dragboard.getFiles().get(0);
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image); // Resmi ImageView'a yükle
        }
        event.setDropCompleted(true);
        event.consume();
    }

    @FXML
    private void handleCreateAd() {
        String tur = turField.getText();
        String renk = renkField.getText();
        String marka = markaField.getText();
        Image image = imageView.getImage();

        if (!tur.isEmpty() && !renk.isEmpty() && !marka.isEmpty() && image != null) {
            Item newItem = new Item(tur, renk, marka, image);
            lostItems.add(newItem);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "İlan oluşturuldu!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Lütfen tüm alanları doldurun ve bir resim ekleyin!");
            alert.showAndWait();
        }
    }

    public static List<Item> getLostItems() {
        return lostItems;
    }
}
