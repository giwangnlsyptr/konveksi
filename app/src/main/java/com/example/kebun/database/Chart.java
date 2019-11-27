package com.example.kebun.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "chart_db")
public class Chart {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "size")
    private String size;

    @ColumnInfo(name = "qty")
    private int qty;

    @ColumnInfo(name = "harga")
    private int harga;

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

}
