package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM User where id LIKE :id")
    User getById(int id);

    @Insert
    void insertAll(User... users);

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);
}
