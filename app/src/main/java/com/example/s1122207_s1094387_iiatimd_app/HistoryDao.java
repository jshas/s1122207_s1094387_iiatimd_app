package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {
    //TODO
    @Query("SELECT * FROM history")
    List<History> getAll();
}
