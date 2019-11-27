package com.example.kebun.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kebun.model.KaosModel;

import java.util.List;

@Dao
public interface ChartDAO {
    @Insert
    long insertData(Chart chart);

    @Query("Select * from chart_db")
    List<Chart> getData();

    @Update
    int updateData(Chart item);

    @Delete
    void deleteData(Chart item);
}
