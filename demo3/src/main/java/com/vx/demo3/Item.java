package com.vx.demo3;

import javafx.scene.image.Image;

public class Item {
    private String tur;
    private String renk;
    private String marka;
    private Image image;

    public Item(String tur, String renk, String marka, Image image) {
        this.tur = tur;
        this.renk = renk;
        this.marka = marka;
        this.image = image;
    }

    // Getter ve Setter metodları
    public String getTur() {
        return tur;
    }

    public String getRenk() {
        return renk;
    }

    public String getMarka() {
        return marka;
    }

    public Image getImage() {
        return image;
    }
}
