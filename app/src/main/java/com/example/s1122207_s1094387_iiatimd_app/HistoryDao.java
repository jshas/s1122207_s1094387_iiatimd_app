package com.example.s1122207_s1094387_iiatimd_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.DatabaseView;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HistoryDao {
    @Query("Select * FROM history;")
    List<History> getAll();

    @Transaction
    @Query("SELECT * FROM history")
    LiveData<HistoryWithMedicinesAndPrescriptions> getHistoryWithMedicinesAndPrescriptions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllHistory(History... history);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHistory(History history);

    @Update()
    void updateHistory(History history);

    @Delete
    void delete(History history);
}
