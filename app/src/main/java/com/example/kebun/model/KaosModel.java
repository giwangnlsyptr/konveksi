package com.example.kebun.model;

public class KaosModel {
    private String type, harga;
    private int image;


    public KaosModel(String type, String harga, int image) {
        this.type = type;
        this.harga = harga;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String  harga) {
        this.harga = harga;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
